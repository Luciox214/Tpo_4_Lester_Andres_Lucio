package view;

import controllers.VentasController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RecaudacionPeliculas extends JFrame {

    /** Atributos de Clase */
    private VentasController ventasController;

    private JTable table;

    private DefaultTableModel tableModel;


    /** Constructor **/
    public RecaudacionPeliculas(){
        setTitle("Peliculas con mayor recaudación");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        ventasController = VentasController.getInstance();
        initUI();
    }

    /** Inicializo la interfaz gráfica con los elementos de la tabla **/
    private void initUI(){

        //Creo el panel que va a contener la tabla:
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        //Creo la tabla:
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Nombre de la pelicula", "Recaudación en ARS"});
        table = new JTable(tableModel);

        //Inicializo un panel con scroll en caso de que hayan muchos datos:
        JScrollPane scrollPane = new JScrollPane(table);

        //Relaciono este scrollPane con el Panel principal:
        panel.add(scrollPane, BorderLayout.CENTER);

        //Añado el panel principal a este Frame:
        add(panel);

        //Activo el método que muestra la recaudación:
        MostrarRecaudacion();
    }

    /** Método que invoca al método reporteMayorRecaudacion y muestra su resultado en la tabla **/
    private void MostrarRecaudacion(){
        //todo: Desarrollar el método que llame a reporteMayorRecaudacion y lo muestre en la tabla.
    }
}
