package view;

import controllers.PeliculasController;
import enums.TipoGenero;
import enums.TipoProyeccion;
import models.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AltaPelicula extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDirector;
    private JTextField txtDuracion;
    private JComboBox<TipoGenero> cbGenero;
    private JComboBox<TipoProyeccion> cbProyeccion;
    private JTextField txtActores;

    private PeliculasController peliculasController;

    public AltaPelicula() {
        setTitle("Alta de Película");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        peliculasController = PeliculasController.getInstance();
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();

        JLabel lblDirector = new JLabel("Director:");
        txtDirector = new JTextField();

        JLabel lblDuracion = new JLabel("Duración (en minutos):");
        txtDuracion = new JTextField();

        JLabel lblGenero = new JLabel("Género:");
        cbGenero = new JComboBox<>(TipoGenero.values());

        JLabel lblProyeccion = new JLabel("Tipo de Proyección:");
        cbProyeccion = new JComboBox<>(TipoProyeccion.values());

        JLabel lblActores = new JLabel("Actores (separados por coma):");
        txtActores = new JTextField();

        JButton btnAgregar = new JButton("Agregar Película");

        // Acción del botón "Agregar"
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPelicula();
            }
        });

        panel.add(lblNombre);
        panel.add(txtNombre);

        panel.add(lblDirector);
        panel.add(txtDirector);

        panel.add(lblDuracion);
        panel.add(txtDuracion);

        panel.add(lblGenero);
        panel.add(cbGenero);

        panel.add(lblProyeccion);
        panel.add(cbProyeccion);

        panel.add(lblActores);
        panel.add(txtActores);

        panel.add(new JLabel()); // Espacio vacío
        panel.add(btnAgregar);

        add(panel);
    }

    private void agregarPelicula() {
        try {
            String nombre = txtNombre.getText().trim();
            String director = txtDirector.getText().trim();
            int duracion = Integer.parseInt(txtDuracion.getText().trim());
            TipoGenero genero = (TipoGenero) cbGenero.getSelectedItem();
            TipoProyeccion proyeccion = (TipoProyeccion) cbProyeccion.getSelectedItem();
            String[] actores = txtActores.getText().trim().split(",");

            if (nombre.isEmpty() || director.isEmpty() || actores.length == 0) {
                throw new IllegalArgumentException("Todos los campos deben estar completos.");
            }

            Pelicula nuevaPelicula = new Pelicula(genero, director, duracion, nombre, proyeccion, Arrays.asList(actores), null);
            peliculasController.getPeliculas().add(nuevaPelicula);

            JOptionPane.showMessageDialog(this, "Película agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Duración debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtDirector.setText("");
        txtDuracion.setText("");
        txtActores.setText("");
        cbGenero.setSelectedIndex(0);
        cbProyeccion.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AltaPelicula altaPelicula = new AltaPelicula();
            altaPelicula.setVisible(true);
        });
    }
}
