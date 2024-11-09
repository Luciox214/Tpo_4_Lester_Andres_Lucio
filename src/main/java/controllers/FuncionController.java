package controllers;

import dto.AltaFuncionDTO;
import dto.FuncionDTO;
import enums.TipoGenero;
import enums.TipoProyeccion;
import models.Entrada;
import models.Funcion;
import models.Pelicula;
import models.Sala;
import models.Sucursal;
import controllers.SucursalController;
import controllers.PeliculasController;

import java.util.*;

/**
 * 
 */
public class FuncionController {
	
	private List<Funcion> funciones;

	public static FuncionController instancia;

    private SucursalController sucursalController = SucursalController.getInstance();

    private PeliculasController peliculasController = PeliculasController.getInstance();
	
	FuncionController() {
    	funciones = new ArrayList<Funcion>();
    	funciones.add(new Funcion(new Date(), 1, "11:00", new ArrayList<Entrada>(), new Sala(0, null, 0),
                new Pelicula(TipoGenero.Terror,"steven spielberg",120,"Tiburon", TipoProyeccion.DosD,new ArrayList<>(),null)));

    }

    /**
     * Default constructor
     */





    /** ----> SECCION DE ABM <---- */
    public void AltaDeUnaFuncion(AltaFuncionDTO dto) throws Exception {

        //Almaceno la fecha actual en una variable:
        Date fechaActual = new Date();

        //Genero un funcionID aleatorio entre 1000 y 9999:
        Random random = new Random();
        int funcionID = 1000 + random.nextInt(9000);

        //Estraigo el horario del DTO en una variable:
        String horarioFuncion = dto.getHorario();

        //Extraigo la sucursal del dto en una variable:
        String nombreSucursal = dto.getSucursal();

        //Busco la sucursal en la lista de sucursales de su controller:
        Sucursal sucursalDeLaFuncion = buscarSucursalPorNombre(nombreSucursal);

        //Busco la sala en la lista de salas de la sucursal:
        Sala salaDeLaFuncion;

        try{
            for(Sala sala : sucursalDeLaFuncion.getSalas()){
                if (sala.getDenominacion().equals(dto.getSala())){
                    salaDeLaFuncion = sala;
                }
            }
        } catch (Exception e){throw new Exception("No se encontró la sala ingresada");}

        //todo: ----> Busco la pelicula en la lista de peliculas de su controller correspondiente:


    }

    private Sucursal buscarSucursalPorNombre(String nombreSucursal) throws Exception{
        try {
            for (Sucursal sucursal : sucursalController.getSucursal()){
                if (nombreSucursal.equals(sucursal.getDenominacion())){
                    return sucursal;
                }
            }
        } catch (Exception e){throw new Exception("No se encontró la sucursal ingresada");}
        return null;
    }

    private Pelicula buscarPeliculaPorNombre(String nombrePelicula) throws Exception{

        try{
            for(Pelicula pelicula : peliculasController.getPeliculas()){
                if(pelicula.getNombrePelicula().equals(nombrePelicula)){
                    return pelicula;
                }
            }
        } catch (Exception e){throw new Exception("No se encontró la película ingresada");}
        return null;
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