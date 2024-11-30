package view;

import controllers.VentasController;
import dto.PeliculaDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

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

        try{
            //Creo la lista que almacena cada pelicula con su recaudacion:
            ArrayList<PeliculaDTO> pelisYRecaudaciones = ventasController.reporteMayorRecaudación();

            //Limpio la tabla antes de agregar los resultados:
            tableModel.setRowCount(0);

            //Recorro la lista de peliculas:
            for(PeliculaDTO pelicula : pelisYRecaudaciones){

                //Agrego una nueva fila por cada set de pelicula y recaudacion:
                tableModel.addRow(new Object[]{
                        pelicula.getNombreDTO(),
                        pelicula.getRecaudación()
                });
            }

        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            tableModel.setRowCount(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecaudacionPeliculas ui = new RecaudacionPeliculas();
            ui.setVisible(true);
        });
    }
}
