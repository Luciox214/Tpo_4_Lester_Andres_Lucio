package view;

import controllers.PeliculasController;
import dto.PeliculaDTO;
import enums.TipoGenero;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultaPelicula extends JFrame {


    private PeliculasController peliculasController;
    private  JTable table;
    private DefaultTableModel tableModel;
    public ConsultaPelicula(){
        setTitle("Consulta de pelicula");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        peliculasController = PeliculasController.getInstance();
        initUI();

    }

    private void initUI(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenuItem itemTerror = new JMenuItem("Terror");
        JMenuItem itemRomance = new JMenuItem("Romance");
        JMenuItem itemDrama = new JMenuItem("Drama");
        JMenuItem itemSuspenso = new JMenuItem("Suspenso");
        JMenuItem itemBiografica = new JMenuItem("Biografica");


        itemRomance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPeliculaPorgenero(itemRomance.getText());
            }
        });

        itemTerror.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPeliculaPorgenero(itemTerror.getText());
            }
        });

        itemSuspenso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPeliculaPorgenero(itemSuspenso.getText());
            }
        });

        itemBiografica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPeliculaPorgenero(itemBiografica.getText());
            }
        });

        itemDrama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPeliculaPorgenero(itemDrama.getText());
            }
        });


        menuBar.add(itemRomance);
        menuBar.add(itemTerror);
        menuBar.add(itemDrama);
        menuBar.add(itemSuspenso);
        menuBar.add(itemBiografica);

        setJMenuBar(menuBar);

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Nombre", "Duracion","Director","Genero"});
        table= new JTable(tableModel);

        JScrollPane scrollPanel = new JScrollPane(table);

        panel.add(scrollPanel, BorderLayout.CENTER);

        add(panel);


    }


    private void buscarPeliculaPorgenero(String genero) {
        TipoGenero tipoGenero = null;

        // Determina el tipo de género basado en la entrada
        if (genero.equals("Romance")) {
            tipoGenero = TipoGenero.Romance;
        } else if (genero.equals("Terror")) {
            tipoGenero = TipoGenero.Terror;
        } else if (genero.equals("Drama")) {
            tipoGenero = TipoGenero.Drama;
        } else if (genero.equals("Suspenso")) {
            tipoGenero = TipoGenero.Suspenso;
        } else if (genero.equals("Biografica")) {
            tipoGenero = TipoGenero.Biografica;
        }


        try {
            ArrayList<PeliculaDTO> peliculas = peliculasController.buscarPeliculaPorGenero(tipoGenero);
            tableModel.setRowCount(0); // Limpia la tabla antes de agregar los resultados

            for (PeliculaDTO pelicula : peliculas) {
                tableModel.addRow(new Object[]{
                        pelicula.getNombreDTO(),
                        pelicula.getDuracionDTO(),
                        pelicula.getDirectorDTO(),
                        pelicula.getGeneroDTO()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            tableModel.setRowCount(0);
        }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultaPelicula ui = new ConsultaPelicula();
            ui.setVisible(true);
        });
    }


    /*
    cambio
     */
}
