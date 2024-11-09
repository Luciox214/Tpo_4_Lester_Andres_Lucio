package controllers;

import models.Sala;
import models.Sucursal;

import java.util.*;


/**
 * 
 */
public class SucursalController {

    /**
     * Default constructor
     */
	
	private List<Sucursal> sucursal;
    private static SucursalController INSTANCE;


		
    private SucursalController() {
        preCargaSucursalesYSalas();
    }

    public static SucursalController getInstance(){
        if(INSTANCE==null){
            INSTANCE =  new SucursalController();
        }

        return INSTANCE;
    }

    /**
     * @param id 
     * @param denom 
     * @param dir
     */
    public void agregarSucursal(int id, String denom, String dir) {
        // TODO implement here
    }

    /**
     * @param idSucursal 
     * @param salaID 
     * @param denom 
     * @param nroasientos
     */
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        // TODO implement here
    }


    private void preCargaSucursalesYSalas(){
        this.sucursal = new ArrayList<Sucursal>();

        ArrayList<Sala> salasSucursal1= new ArrayList<>();
        salasSucursal1.add( new Sala(1,"SALA A" , 20));
        salasSucursal1.add( new Sala(2,"SALA B" , 20));
        salasSucursal1.add( new Sala(3,"SALA C" , 25));

        ArrayList<Sala> salasSucursal2= new ArrayList<>();
        salasSucursal2.add( new Sala(1,"SALA A" , 20));
        salasSucursal2.add( new Sala(2,"SALA B" , 20));
        salasSucursal2.add( new Sala(3,"SALA C" , 25));

        sucursal.add(new Sucursal(1, "Sucursal 1", "Av Montes de Oca 1100", salasSucursal1));
        sucursal.add(new Sucursal(2, "Sucursal 2", "Beruti 3399", salasSucursal2));

    }

    public List<Sucursal> getSucursal() {
        return sucursal;
    }
}