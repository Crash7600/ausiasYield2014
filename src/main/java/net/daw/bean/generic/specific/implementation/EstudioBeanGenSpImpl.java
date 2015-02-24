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
package net.daw.bean.generic.specific.implementation;

import net.daw.bean.generic.implementation.BeanGenImpl;
import net.daw.bean.publicinterface.BeanInterface;
import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 *
 * @author al037805
 */
public class EstudioBeanGenSpImpl extends BeanGenImpl implements BeanInterface{
    
    public EstudioBeanGenSpImpl() {
    }

    public EstudioBeanGenSpImpl(Integer id) {
        super(id);
    }
    
    @Expose
    private String nombre_estudio = "";
    @Expose
    private String ciudad_estudio = "";
    //private String presentacion = "";
    @Expose
    private Integer telefono = 0;

    /**
     * @return the nombre_estudio
     */
    public String getNombre_estudio() {
        return nombre_estudio;
    }

    /**
     * @param nombre_estudio the nombre_estudio to set
     */
    public void setNombre_estudio(String nombre_estudio) {
        this.nombre_estudio = nombre_estudio;
    }

    /**
     * @return the ciudad_estudio
     */
    public String getCiudad_estudio() {
        return ciudad_estudio;
    }

    /**
     * @param ciudad_estudio the ciudad_estudio to set
     */
    public void setCiudad_estudio(String ciudad_estudio) {
        this.ciudad_estudio = ciudad_estudio;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    


    
    
}
