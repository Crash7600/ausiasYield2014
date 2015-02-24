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
import net.daw.bean.generic.specific.implementation.DirectorBeanGenSpImpl;
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
public class DirectorDaoSpcImpl implements ViewDaoInterface<DirectorBeanGenSpImpl>, TableDaoInterface<DirectorBeanGenSpImpl>, MetaDaoInterface {

    private String strTableName = null;
    private MysqlDataSpImpl oMysql = null;
    private Connection oConnection = null;

    public DirectorDaoSpcImpl(String ob, Connection oConexion) throws Exception {
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
    public ArrayList<DirectorBeanGenSpImpl> getPage(int intRegsPerPag, int intPage, ArrayList<FilterBeanHelper> hmFilter, HashMap<String, String> hmOrder) throws Exception {
        ArrayList<Integer> arrId;
        ArrayList<DirectorBeanGenSpImpl> arrDirector = new ArrayList<>();
        try {
            arrId = oMysql.getPage(strTableName, intRegsPerPag, intPage, hmFilter, hmOrder);
            Iterator<Integer> iterador = arrId.listIterator();
            while (iterador.hasNext()) {
                DirectorBeanGenSpImpl oDirectorBean = new DirectorBeanGenSpImpl(iterador.next());
                arrDirector.add(this.get(oDirectorBean, 1));
            }
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":getPage ERROR: " + ex.getMessage()));
        }
        return arrDirector;
    }

    @Override
    public DirectorBeanGenSpImpl get(DirectorBeanGenSpImpl oDirectorBean, Integer expand) throws Exception {
        if (oDirectorBean.getId() > 0) {
            try {
                if (!oMysql.existsOne(strTableName, oDirectorBean.getId())) {
                    oDirectorBean.setId(0);
                } else {
                    oDirectorBean.setNombre_director(oMysql.getOne(strTableName, "nombre_director", oDirectorBean.getId()));
                    oDirectorBean.setNacionalidad(oMysql.getOne(strTableName, "nacionalidad", oDirectorBean.getId()));
                    
                    String fecha = "";
                    fecha = oMysql.getOne(strTableName, "anyo_inicio", oDirectorBean.getId());
                    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    oDirectorBean.setAnyo_inicio(date.parse(fecha));
                    
                    String fecha2 = "";
                    fecha2 = oMysql.getOne(strTableName, "anyo_fin", oDirectorBean.getId());
                    SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    oDirectorBean.setAnyo_fin(date2.parse(fecha2));

                    

                }
            } catch (Exception ex) {
                ExceptionBooster.boost(new Exception(this.getClass().getName() + ":get ERROR: " + ex.getMessage()));
            }
        } else {
            oDirectorBean.setId(0);
        }
        return oDirectorBean;
    }

    @Override
    public DirectorBeanGenSpImpl set(DirectorBeanGenSpImpl oDirectorBean) throws Exception {
        try {
            if (oDirectorBean.getId() == 0) {
                oDirectorBean.setId(oMysql.insertOne(strTableName));
            }
            oMysql.updateOne(oDirectorBean.getId(), strTableName, "nombre_director", oDirectorBean.getNombre_director());
            oMysql.updateOne(oDirectorBean.getId(), strTableName, "nacionalidad", oDirectorBean.getNacionalidad());
            
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            oMysql.updateOne(oDirectorBean.getId(), strTableName, "anyo_inicio", date.format(oDirectorBean.getAnyo_inicio()));
            
            SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            oMysql.updateOne(oDirectorBean.getId(), strTableName, "anyo_fin", date2.format(oDirectorBean.getAnyo_fin()));

            

            
        } catch (Exception ex) {
            ExceptionBooster.boost(new Exception(this.getClass().getName() + ":set ERROR: " + ex.getMessage()));
        }
        return oDirectorBean;
    }

    @Override
    public int remove(DirectorBeanGenSpImpl oDirectorBean) throws Exception {
        int result = 0;
        try {
            result = oMysql.removeOne(oDirectorBean.getId(), strTableName);
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
