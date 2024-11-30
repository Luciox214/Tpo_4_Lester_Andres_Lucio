package controllers;

import controllers.FuncionController;
import models.*;
import dto.*;
import enums.*;

import java.util.*;


/**
 * 
 */
public class VentasController {

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * ATRIBUTOS DE CLASE
     */
    private List<Venta> ventas;

    private FuncionController funcionController =  new FuncionController();

    private static VentasController instancia;
	
    public VentasController(){
        ventas = new ArrayList<Venta>();
        preCargaDeFunciones();
    }

    public static VentasController getInstance(){
        if(instancia == null){
            instancia = new VentasController();
        }
        return instancia;
    }

    public float recaudacionPorFuncion(int funcionID) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * Caso de secuencia a desarrollar
     * @param /*peliculaID
     * @return
     */

    private void preCargaDeFunciones(){

        for(Funcion funcion : funcionController.getListaFunciones()){
            ventas.add(new Venta(1,new Date(), null, funcion));
        }
    }

    public ArrayList<PeliculaDTO> reporteMayorRecaudación(){

        //Lista de funciones con ventas:
        List<Funcion> funcionesConVenta = new  ArrayList<>();

        //Lista de PeliculaDTO para guardar la pelicula y su recaudacion:
        ArrayList<PeliculaDTO> peliculasReporte = new ArrayList<>();

        //Recorremos las funciones:
        for (Funcion funcion:funcionController.getListaFunciones()){
            if (buscarVentaPorFuncion(funcion) != null){
                funcionesConVenta.add(funcion);
            }
        }

        Map<String,Float> PelisYRecaudaciones = new HashMap<>();

        //Recorremos las funciones que sí tienen venta:
        for (Funcion funcion : funcionesConVenta){
            String nombrePeli = funcion.getPelicula().getNombrePelicula();
            Float recaudacion = recaudacionPorPelicula(nombrePeli);

            PelisYRecaudaciones.put(nombrePeli,PelisYRecaudaciones.getOrDefault(nombrePeli,0.0f) + recaudacion);

        }

        //Recorremos el diccionario para crear la lista de DTOs:
        for (Map.Entry<String, Float> entry : PelisYRecaudaciones.entrySet()) {
            String nombrePelicula = entry.getKey();
            Float recaudacionTotal = entry.getValue();

            // Crear el DTO y agregarlo a la lista
            PeliculaDTO peliculaDTO = new PeliculaDTO(nombrePelicula, String.valueOf(recaudacionTotal));
            peliculasReporte.add(peliculaDTO);
        }

        //Ordenar la lista de peliculaDTO
        Collections.sort(peliculasReporte, new Comparator<PeliculaDTO>() {
            @Override
            public int compare(PeliculaDTO p1, PeliculaDTO p2) {

                float recaudacion1 = Float.valueOf(p1.getRecaudación());
                float recaudacion2 = Float.valueOf(p2.getRecaudación());
                return Float.compare(recaudacion2,recaudacion1);
            }
        });

        return peliculasReporte;
    }

    public float recaudacionPorPelicula(String nombrePelicula) {

        float totalRecaudado = (float)0.0;

        for(Venta venta:ventas){
            Funcion funcion = venta.getFuncion();

            Pelicula pelicula = funcion.getPelicula();

            if (pelicula.getNombrePelicula().equals(nombrePelicula)){
                totalRecaudado += venta.getTotal();
            }
        }

        return totalRecaudado;



        /*
        List<Funcion> funciones = funcionController.buscarPeliculaPorFuncion(peliculaID);
        if(funciones.isEmpty()){
            return 0;
        }
        float totalrecuadado = 0.0f;
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(Objects.isNull(venta)){
                totalrecuadado=+venta.calcularMontoDeLaVentaPorFuncionCombos();
            }
        }
    	return totalrecuadado;

         */
    }

    /**
     * @param tipoTarjeta 
     * @return
     */
    public float recaudacionPorTarjetaDescuento(TipoTarjeta tipoTarjeta) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * 
     */
    public void comboMasVendido() {
        // TODO implement here
    }

    private Venta buscarVentaPorFuncion(Funcion funcion){
        for (Venta venta:getVentas()) {
            if(Objects.equals(funcion,venta.getFuncion())){
                return venta;
            }
        }
        return null;
    }

    /**
     * View a desarrollar
     *
     * @param genero
     * @return
     */
    public List<VentaDto> funcionesVendidasPorGenero(TipoGenero genero) {
        List<VentaDto> ventaDtos = new ArrayList<>();
        List<Funcion> funciones = funcionController.buscarPeliculaPorGenerosFuncion(genero);
        if(funciones.isEmpty()){
            return ventaDtos;
        }
        for (Funcion funcion:funciones) {
            Venta venta = buscarVentaPorFuncion(funcion);
            if(Objects.isNull(venta)){
                ventaDtos.add(modelVentaToDto(venta));
            }
        }
        return ventaDtos;
    }

    public VentaDto modelVentaToDto(Venta venta){
        return new VentaDto(modelFuncionToDto(venta.getFuncion()));
    }

    public FuncionDTO modelFuncionToDto(Funcion funcion){
        return new FuncionDTO(funcion);
    }

}