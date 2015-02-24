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
public class DirectorBeanGenSpImpl extends BeanGenImpl implements BeanInterface{
    
    public DirectorBeanGenSpImpl() {
    }

    public DirectorBeanGenSpImpl(Integer id) {
        super(id);
    }
    
    @Expose
    private String nombre_director = "";
    @Expose
    private String nacionalidad = "";
    //private String presentacion = "";
    @Expose
    private Date anyo_inicio = new Date();
    @Expose
    private Date anyo_fin = new Date();

    /**
     * @return the nombre_director
     */
    public String getNombre_director() {
        return nombre_director;
    }

    /**
     * @param nombre_director the nombre_director to set
     */
    public void setNombre_director(String nombre_director) {
        this.nombre_director = nombre_director;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the año_inicio
     */
    public Date getAnyo_inicio() {
        return anyo_inicio;
    }

    /**
     * @param anyo_inicio the año_inicio to set
     */
    public void setAnyo_inicio(Date anyo_inicio) {
        this.anyo_inicio = anyo_inicio;
    }

    /**
     * @return the anyo_fin
     */
    public Date getAnyo_fin() {
        return anyo_fin;
    }

    /**
     * @param anyo_fin the año_fin to set
     */
    public void setAnyo_fin(Date anyo_fin) {
        this.anyo_fin = anyo_fin;
    }
    


    
    
    
}
