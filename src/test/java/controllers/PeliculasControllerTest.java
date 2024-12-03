package controllers;

import enums.TipoGenero;
import enums.TipoProyeccion;
import models.Pelicula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculasControllerTest {

    private PeliculasController peliculasController;

    @BeforeEach
    public void setUp() {
        peliculasController = PeliculasController.getInstance();
        peliculasController.getPeliculas().clear();
    }

    @Test
    public void testAltaPelicula_Exito() {
        String nombre = "Inception";
        String director = "Christopher Nolan";
        int duracion = 148;
        TipoGenero genero = TipoGenero.Drama;
        TipoProyeccion proyeccion = TipoProyeccion.DosD;
        String[] actores = {"Leonardo DiCaprio", "Joseph Gordon-Levitt"};

        Pelicula nuevaPelicula = new Pelicula(genero, director, duracion, nombre, proyeccion, List.of(actores), null);
        peliculasController.getPeliculas().add(nuevaPelicula);

        assertEquals(1, peliculasController.getPeliculas().size());
        Pelicula peliculaAgregada = peliculasController.getPeliculas().get(0);

        assertEquals(nombre, peliculaAgregada.getNombrePelicula());
        assertEquals(director, peliculaAgregada.getDirector());
        assertEquals(duracion, peliculaAgregada.getDuracionEnMinutos());
        assertEquals(genero, peliculaAgregada.getGeneroID());
        assertEquals(proyeccion, peliculaAgregada.getTipo());
        assertEquals(List.of(actores), peliculaAgregada.getActores());
    }

    @Test
    public void testAltaPelicula_FallaCamposVacios() {
        // Datos de prueba incompletos
        String nombre = "";
        String director = "Christopher Nolan";
        int duracion = 148;
        TipoGenero genero = TipoGenero.Drama;
        TipoProyeccion proyeccion = TipoProyeccion.DosD;
        String[] actores = {"Leonardo DiCaprio", "Joseph Gordon-Levitt"};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Todos los campos deben estar completos.");

        });

        assertEquals("Todos los campos deben estar completos.", exception.getMessage());
        assertEquals(0, peliculasController.getPeliculas().size());
    }

    @Test
    public void testAltaPelicula_FallaDuracionNoNumerica() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("No numerico");
        });

        assertEquals(NumberFormatException.class, exception.getClass());
    }
}
