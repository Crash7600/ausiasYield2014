/*
 * Copyright (C) 2014 al037805
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package net.daw.dao.specific.implementation;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import net.daw.bean.generic.specific.implementation.EstudioBeanGenSpImpl;
import net.daw.dao.publicinterface.MetaDaoInterface;
import net.daw.dao.publicinterface.TableDaoInterface;
import net.daw.dao.publicinterface.ViewDaoInterface;
import net.daw.data.specific.implementation.MysqlDataSpImpl;
import net.daw.helper.ExceptionBooster;
import net.daw.helper.FilterBeanHelper;

/**
 *
 * @author al037805
 */
public class EstudioDaoSpcImpl implements ViewDaoInterface<EstudioBeanGenSpImpl>, TableDaoInterface<EstudioBeanGenSpImpl>, MetaDaoInterface {

    private String strTableName = null;
    private MysqlDataSpImpl oMysql = null;
    private Connection oConnection = null;

    public EstudioDaoSpcImpl(String ob, Connection oConexion) throws Exception {
        try {
            strTableName = ob;
            oConnection = oConexion;
            oMysql = new MysqlDataSpImpl(oConnection);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":constructor ERROR: " + ex.getMessage()));
        }
    }

    @Override
    public int getPages(int intRegsPerPag, ArrayList<FilterBeanHelper> hmFilter) throws Exception {
        int pages = 0;
        try {
            pages = oMysql.getPages(strTableName, intRegsPerPag, hmFilter);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPages ERROR: " + ex.getMessage()));
        }
        return pages;
    }

    @Override
    public int getCount(ArrayList<FilterBeanHelper> hmFilter) throws Exception {
        int pages = 0;
        try {
            pages = oMysql.getCount(strTableName, hmFilter);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getCount ERROR: " + ex.getMessage()));
        }
        return pages;
    }

    @Override
    public ArrayList<EstudioBeanGenSpImpl> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBeanHelper> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<EstudioBeanGenSpImpl> arrEstudio = new ArrayList<>();
        try {
            arrId = oMysql.getPage(strTableName, intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                EstudioBeanGenSpImpl oEstudioBean = new EstudioBeanGenSpImpl(iterador.next());
                arrEstudio.add(this.get(oEstudioBean, 1));
            }
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPage ERROR: " + ex.getMessage()));
        }
        return arrEstudio;
    }

    @Override
    public EstudioBeanGenSpImpl get(EstudioBeanGenSpImpl oEstudioBean, Integer expand) throws Exception {
        if (oEstudioBean.getId() > 0) {
            try {
                if (!oMysql.existsOne(strTableName, oEstudioBean.getId())) {
                    oEstudioBean.setId(0);
                } else {
                    oEstudioBean.setNombre_estudio(oMysql.getOne(strTableName, "nombre_estudio", oEstudioBean.getId()));
                    oEstudioBean.setCiudad_estudio(oMysql.getOne(strTableName, "ciudad_estudio", oEstudioBean.getId()));

                    

                    oEstudioBean.setTelefono(Integer.valueOf(oMysql.getOne(strTableName, "telefono", oEstudioBean.getId())));
                    

                }
            } catch (Exception ex) {
                ExceptionBooster.boost(new Exception(this.getClass().getName() + ":get ERROR: " + ex.getMessage()));
            }
        } else {
            oEstudioBean.setId(0);
        }
        return oEstudioBean;
    }

    @Override
    public EstudioBeanGenSpImpl set(EstudioBeanGenSpImpl oEstudioBean) throws Exception {
        try {
            if (oEstudioBean.getId() == 0) {
                oEstudioBean.setId(oMysql.insertOne(strTableName));
            }
            oMysql.updateOne(oEstudioBean.getId(), strTableName, "nombre_estudio", oEstudioBean.getNombre_estudio());
            oMysql.updateOne(oEstudioBean.getId(), strTableName, "ciudad_estudio", oEstudioBean.getCiudad_estudio());

            

            oMysql.updateOne(oEstudioBean.getId(), strTableName, "telefono", oEstudioBean.getTelefono().toString());

            
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return oEstudioBean;
    }

    @Override
    public int remove(EstudioBeanGenSpImpl oEstudioBean) throws Exception {
        int result = 0;
        try {
            result = oMysql.removeOne(oEstudioBean.getId(), strTableName);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":remove ERROR: " + ex.getMessage()));
        }
        return result;
    }

    @Override
    public ArrayList<String> getColumnsNames() throws Exception {
        ArrayList<String> alColumns = null;
        try {
            alColumns = oMysql.getColumnsName(strTableName);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getColumnsNames ERROR: " + ex.getMessage()));
        }
        return alColumns;
    }

    @Override
    public ArrayList<String> getPrettyColumnsNames() throws Exception {
        ArrayList<String> alColumns = null;
        try {
            alColumns = oMysql.getPrettyColumns(strTableName);
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPrettyColumnsNames ERROR: " + ex.getMessage()));
        }
        return alColumns;
    }

    @Override
    public int updateOne(int intId, String strTabla, String strCampo, String strValor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
