package controllers;

import enums.TipoTarjeta;
import models.CondicionesDescuento;
import models.TarjetaDescuento;

import java.util.*;



/**
 * 
 */
public class DescuentoController {
	
	
	private static DescuentoController instancia;
	
	private List<CondicionesDescuento> Descuento;
	
    private DescuentoController() {
    	Descuento = new ArrayList<CondicionesDescuento>();
    	CondicionesDescuento CondicionesDescuento = new CondicionesDescuento(new Date(), new Date(), 5, 50, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuento>());
    	Descuento.add(CondicionesDescuento);
    	
    }
	public static DescuentoController getDescuentoControllerInstance(){
		if (instancia == null) {
			instancia = new DescuentoController();
		}
		return instancia;
	}

    /**
     * Lucio: Modifiqué el constructor para que sea privado, y cree el método getInstance para acceder a la instancia
     */
    public void ABM() {
	}


}