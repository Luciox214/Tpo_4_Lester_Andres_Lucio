package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame implements ActionListener {
    private JPanel pnlPrincipal;
    private JPanel pnlTituloMenuP;
    private JPanel pnlBodyPrincipal;
    private JLabel MenuPrincipalTitulo;
    private JMenuBar BarraMenu;
    private JMenu AltasMenu;
    private JMenu ConsultasMenu;

    private JMenuItem altaFuncion, altaPelicula, consultaGenero;

    // Constructor:
    public MenuPrincipal(String titulo) {

        // 1) Asigno el titulo a este frame:
        super(titulo);

        // 2) Asigno el panel a este frame:
        setContentPane(pnlPrincipal);

        // 3) Establezco el comportamiento de la ventana al cerrarse:
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 4) Inicio la posición de la pantalla centrada:
        setLocationRelativeTo(null);

        // 5) Seteo el tamaño de la ventana por defecto:
        setSize(400, 400);

        /* Creación y asignación de los submenús e ítems de menú */

        // Instancio y agrego los ítems al menú AltasMenu:
        altaFuncion = new JMenuItem("Alta de Funcion");
        altaPelicula = new JMenuItem("Alta de Pelicula");
        consultaGenero = new JMenuItem("Consulta pelicula por genero");

        // Agrego los ítems a los menús correspondientes:
        ConsultasMenu.add(consultaGenero);
        AltasMenu.add(altaFuncion);
        AltasMenu.add(altaPelicula);

        // Asocio los ActionListeners a sus respectivos ítems:
        altaFuncion.addActionListener(this);
        altaPelicula.addActionListener(this);
        consultaGenero.addActionListener(this);

        // Agrego los menús a la barra de menú:
        BarraMenu = new JMenuBar();
        BarraMenu.add(AltasMenu);
        BarraMenu.add(ConsultasMenu);

        // Asigno la barra de menú a la ventana:
        setJMenuBar(BarraMenu);
    }

    /* Creación del método main para arrancar el programa desde aquí */
    public static void main(String[] args) {

        // Creo una instancia de este frame:
        MenuPrincipal menuPrincipal = new MenuPrincipal("Menu Principal del Cine");

        // Vuelvo visible la instancia:
        menuPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Defino acciones cuando hago clic en el ítem de AltaFuncion:
        if (e.getSource() == altaFuncion) {
            AltaFuncion alta = new AltaFuncion("Creación de una nueva función");
            alta.setVisible(true);
        }

        // Defino acciones cuando hago clic en el ítem de AltaPelicula:
        if (e.getSource() == altaPelicula) {
            // Invocación a la ventana donde se hace el alta de una película
            AltaPelicula altaPelicula = new AltaPelicula();
            altaPelicula.setVisible(true);
        }

        // Defino acciones cuando hago clic en el ítem de ConsultaGenero:
        if (e.getSource() == consultaGenero) {
            ConsultaPelicula consultaPelicula = new ConsultaPelicula();
            consultaPelicula.setVisible(true);
        }
    }
}
