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
public class GeneroBeanGenSpImpl extends BeanGenImpl implements BeanInterface{
    
    public GeneroBeanGenSpImpl() {
    }

    public GeneroBeanGenSpImpl(Integer id) {
        super(id);
    }
    
    @Expose
    private String tipo_genero = "";
    //private String presentacion = "";

    /**
     * @return the tipo_genero
     */
    public String getTipo_genero() {
        return tipo_genero;
    }

    /**
     * @param tipo_genero the tipo_genero to set
     */
    public void setTipo_genero(String tipo_genero) {
        this.tipo_genero = tipo_genero;
    }


    

    
}
