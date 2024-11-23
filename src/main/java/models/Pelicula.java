package models;

import enums.TipoGenero;
import enums.TipoProyeccion;
import models.CondicionesDescuento;

import java.util.*;

/**
 *
 */
public class Pelicula {

    /**
     * Default constructor
     */
    public Pelicula(TipoGenero generoID, String director, int duracionEnMinutos, String nombrePelicula, TipoProyeccion tipo, List<String> actores, CondicionesDescuento descuento) {

        this.actores = actores;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.tipo = tipo;
        this.condicionesDescuento = descuento;



    }

    public TipoGenero getGeneroID() {
        return generoID;
    }

    public void setGeneroID(TipoGenero generoID) {
        this.generoID = generoID;
    }

    /**
     *
     */
    private TipoGenero generoID;

    /**
     *
     */
    private String nombrePelicula;

    /**
     *
     */
    private int duracionEnMinutos;

    /**
     *
     */
    private String director;

    /**
     *
     */
    private List<String> actores;

    /**
     *
     */
    private TipoProyeccion tipo;

    private int peliculaID;

    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }

    private CondicionesDescuento condicionesDescuento;


    /**
     *
     */
    public int getPeliculaID() {
        // TODO implement here
        return 0;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public TipoProyeccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoProyeccion tipo) {
        this.tipo = tipo;
    }

    public void setCondicionesDescuento(CondicionesDescuento condicionesDescuento) {
        this.condicionesDescuento = condicionesDescuento;
    }


}