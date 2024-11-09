package controllers;

import enums.TipoGenero;
import enums.TipoProyeccion;
import models.Pelicula;

import java.util.*;


/**
 * 
 */
    	
public class PeliculasController {

    /**
     * Default constructor
     */
	
	private List<Pelicula> peliculas;
    private static PeliculasController INSTANCE;
	
    private PeliculasController() {

        preCargarPaeliculas();
    }

    public static PeliculasController getInstance(){
        if(INSTANCE==null){
            INSTANCE = new PeliculasController();
        }

        return INSTANCE;
    }

    /**
     * 
     */
    public void ABM() {
        // TODO implement here
    }

    public void preCargarPaeliculas(){
        peliculas= new ArrayList<Pelicula>();
        peliculas.add(new Pelicula(TipoGenero.Romance, "Damian Chazelle", 180 , "La La Land", TipoProyeccion.DosD, Arrays.asList("Ryan Gosling", "Emma Stone"),null));
        peliculas.add(new Pelicula(TipoGenero.Suspenso, "Matt Reeves", 180 , "The Batman", TipoProyeccion.TresDMax, Arrays.asList("Robert Pattinson", "Zoe Kravitz"),null));
        peliculas.add(new Pelicula(TipoGenero.Biografica, "David Fincher", 180 , "The Social Network", TipoProyeccion.DosD, Arrays.asList("Jesse Eisenberg", "Andrew Garfield"),null));
        peliculas.add(new Pelicula(TipoGenero.Drama, "Alejandro Gonzalez", 180 , "The Revenant", TipoProyeccion.DosD, Arrays.asList("Leonardo Di Caprio", "Tom Hardy"),null));


    }

}