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
public class RepartoBeanGenSpImpl extends BeanGenImpl implements BeanInterface{
    
    public RepartoBeanGenSpImpl() {
    }

    public RepartoBeanGenSpImpl(Integer id) {
        super(id);
    }
    
    @Expose
    private String nombre_actor = "";
    //private String presentacion = "";
    @Expose
    private Date fecha_nacimiento = new Date();
    @Expose
    private String ciudad = "";

    /**
     * @return the nombre_actor
     */
    public String getNombre_actor() {
        return nombre_actor;
    }

    /**
     * @param nombre_actor the nombre_actor to set
     */
    public void setNombre_actor(String nombre_actor) {
        this.nombre_actor = nombre_actor;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    
    
    
}
