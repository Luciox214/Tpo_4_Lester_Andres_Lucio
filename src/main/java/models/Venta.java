package models;

import enums.TipoTarjeta;

import java.util.*;


public class Venta {

    /** Atributos de Clase **/
    private int ventaID;
    private Date fchVenta;
    private List<Combo> combos;
    private Funcion funcion;
    private TarjetaDescuento tarjetaDescuento;

    private float totalVenta;

    /** Default constructor **/
    public Venta(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion) {
    	this.combos = combos;
    	this.funcion = funcion;
    	this.fchVenta = fchVenta;
    }

    /** Constructor auxiliar para definir un total de la venta manualmente **/
    public Venta(int ventaID, Date fchVenta, List<Combo> combos, Funcion funcion,float totalDeLaVenta) {
        this.ventaID = ventaID;
        this.combos = combos;
        this.funcion = funcion;
        this.fchVenta = fchVenta;
        this.totalVenta = totalDeLaVenta;
    }

    /** Getters y Setters **/
    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public TarjetaDescuento getTarjetaDescuento() {
        return tarjetaDescuento;
    }


    public int getFuncionID() {
        // TODO implement here
        return 0;
    }


    public float getTotalVenta() {

        return totalVenta;
    }


    public int getPeliculaID() {
        // TODO implement here
        return 0;
    }

    public TipoTarjeta getTipoTarjeta() {
        // TODO implement here
        return null;
    }


    public List<Combo> getListaComboID() {
		return combos;
		
        // TODO implement here
    }

    /** Métodos de Clase **/
    public float calcularMontoPorComboDeVenta(){
        float total=  0.0f;
        for (Combo combo:getListaComboID()) {
           total =+  (combo.getPrecio()-(combo.getPrecio()*
                   CondicionesDescuento.getDescuentoPorTarjeta(tarjetaDescuento.getTipoTarjeta())));
        }
        return total;
    }


    public float calcularMontoDeLaVentaPorFuncionCombos(){
        return funcion.calcularMontoPorEntradaDeLaPelicula()+calcularMontoPorComboDeVenta();
    }


}