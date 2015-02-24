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
public class PeliculaBeanGenSpImpl extends BeanGenImpl implements BeanInterface{
    
    public PeliculaBeanGenSpImpl() {
    }

    public PeliculaBeanGenSpImpl(Integer id) {
        super(id);
    }
    
    @Expose
    private String nombre_pelicula = "";
    @Expose
    private Integer anyo = 0;
    @Expose
    private String ciudad = "";
    @Expose
    private String website = "";
    @Expose
    private Integer duracion = 0;
    @Expose
    private Integer puntuacion = 0;
    @Expose
    private String url = "";
    //private String presentacion = "";
    @Expose
    private Integer id_genero = 0;

    /**
     * @return the nombre_pelicula
     */
    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    /**
     * @param nombre_pelicula the nombre_pelicula to set
     */
    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    /**
     * @return the anyo
     */
    public Integer getAnyo() {
        return anyo;
    }

    /**
     * @param anyo the anyo to set
     */
    public void setAnyo(Integer anyo) {
        this.anyo = anyo;
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

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the duracion
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the puntuacion
     */
    public Integer getPuntuacion() {
        return puntuacion;
    }

    /**
     * @param puntuacion the puntuacion to set
     */
    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the id_genero
     */
    public Integer getId_genero() {
        return id_genero;
    }

    /**
     * @param id_genero the id_genero to set
     */
    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    

    
}
