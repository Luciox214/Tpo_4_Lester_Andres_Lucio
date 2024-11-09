package controllers;

import dto.AltaFuncionDTO;
import dto.FuncionDTO;
import enums.TipoGenero;
import enums.TipoProyeccion;
import models.Entrada;
import models.Funcion;
import models.Pelicula;
import models.Sala;

import java.util.*;

/**
 * 
 */
public class FuncionController {
	
	private List<Funcion> funciones;

	public static FuncionController instancia;
	
	FuncionController() {
    	funciones = new ArrayList<Funcion>();
    	funciones.add(new Funcion(new Date(), 1, "11:00", new ArrayList<Entrada>(), new Sala(0, null, 0),
                new Pelicula(TipoGenero.Terror,"steven spielberg",120,"Tiburon", TipoProyeccion.DosD,new ArrayList<>(),null)));

    }

    /**
     * Default constructor
     */





    /** ----> SECCION DE ABM <---- */
    public void AltaDeUnaFuncion(AltaFuncionDTO dto) {

        //Almaceno la fecha actual en una variable:
        Date fechaActual = new Date();

        //Genero un funcionID aleatorio entre 1000 y 9999:
        Random random = new Random();
        int funcionID = 1000 + random.nextInt(9000);

        //
    }

    /**
     * @param funcionID 
     * @return
     */
    public int obtenerAsientosDisponiblePorFuncion(int funcionID) {
    	int asientos = -1;
		return asientos;
    }

    /**
     * @param fchFuncion 
     * @return
     */
    public List<FuncionDTO> getListaFunciones(Date fchFuncion) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int peliculaMasVista() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int diaDeLaSemanaConMenorVentas() {
        // TODO implement here
        return 0;
    }

    public List<Funcion> buscarPeliculaPorFuncion(int peliculaID) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPeliculaID() == peliculaID){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funciones;
    }

    public List<Funcion> buscarPeliculaPorGenerosFuncion(TipoGenero genero) {
        List<Funcion> funcionesDeLaPelicula = new ArrayList<>();
        for (Funcion funcion : funciones) {
            if (funcion.getPelicula().getGeneroID() == genero){
                funcionesDeLaPelicula.add(funcion);
            }
        }
        return funciones;
    }
}