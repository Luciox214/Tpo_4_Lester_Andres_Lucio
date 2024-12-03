package controllers;

import dto.PeliculaDTO;
import enums.TipoGenero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculasControllerBusquedaGeneroTest {

    private PeliculasController peliculasController;

    @BeforeEach
    public void setUp() {
        peliculasController = PeliculasController.getInstance();
    }

    @Test
    public void testBuscarPeliculaPorGenero_Exito() {
        TipoGenero genero = TipoGenero.Romance;

        try {
            ArrayList<PeliculaDTO> peliculas = peliculasController.buscarPeliculaPorGenero(genero);

            assertFalse(peliculas.isEmpty());
            peliculas.forEach(pelicula -> assertEquals(genero.toString(), pelicula.getGeneroDTO()));
        } catch (Exception e) {
            fail("No debería lanzar excepción para un género existente.");
        }
    }

    @Test
    public void testBuscarPeliculaPorGenero_SinResultados() {
        TipoGenero genero = TipoGenero.Terror;

        Exception exception = assertThrows(Exception.class, () -> {
            peliculasController.buscarPeliculaPorGenero(genero);
        });

        assertEquals("No hay peliculas por este genero", exception.getMessage());
    }

    @Test
    public void testBuscarPeliculaPorGenero2_Exito() {
        TipoGenero genero = TipoGenero.Drama;

        try {
            ArrayList<PeliculaDTO> peliculas = peliculasController.buscarPeliculaPorGenero2(genero);

            assertFalse(peliculas.isEmpty());

            peliculas.forEach(pelicula -> assertEquals(genero.toString(), pelicula.getGeneroDTO()));
        } catch (Exception e) {
            fail("No debería lanzar excepción para un género existente.");
        }
    }

    @Test
    public void testPreCargarPeliculas() {
        assertNotNull(peliculasController.getPeliculas());
        assertFalse(peliculasController.getPeliculas().isEmpty());
    }
}
