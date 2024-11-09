package controllers;

import dto.PeliculaDTO;
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
        peliculas.add(new Pelicula(TipoGenero.Romance, "Richard Curtis", 123 , "About Time", TipoProyeccion.DosD, Arrays.asList("Domhall Gleeson", "Rachel Adams"),null));



    }

    public ArrayList<PeliculaDTO> buscarPeliculaPorGenero(TipoGenero tipoGenero) throws Exception {

        ArrayList<PeliculaDTO> peliculasDTO= new ArrayList<>();
        for (Pelicula pelicula :peliculas){
            if(pelicula.getGeneroID().equals(tipoGenero)){
                peliculasDTO.add(PeliculaModelToDTO(pelicula));
            }
        }

        if(peliculasDTO.size()==0){
            throw new Exception( "No hay peliculas por este genero");
        }

        return peliculasDTO;

    }

    private PeliculaDTO PeliculaModelToDTO(Pelicula pelicula){
        return new PeliculaDTO(pelicula.getNombrePelicula(),String.valueOf(pelicula.getDuracionEnMinutos()), pelicula.getDirector(), String.valueOf(pelicula.getGeneroID()));

    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }
}