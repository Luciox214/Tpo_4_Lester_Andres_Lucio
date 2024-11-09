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

    private JMenuItem altaFuncion,altaPelicula,consultaGenero;


    //Constructor:
    public MenuPrincipal(String titulo){

        // 1) Asigno el titulo a este frame:
        super(titulo);

        // 2) Asigno el panel a este frame:
        setContentPane(pnlPrincipal);

        // 3) Establezco el comportamiento de la ventana al cerrarse:
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 4) Inicio la posición de la pantalla centrada:
        setLocationRelativeTo(null);

        // 5) Seteo el tamaño de la ventana por defecto:
        setSize(400,400);


        /*Creación y asignación de los Submenus e items de menu*/

        //Instancio y agrego los items al menu AltasMenu:
        altaFuncion = new JMenuItem("Alta de Funcion");
        altaPelicula = new JMenuItem("Alta de Pelicula");
        consultaGenero = new JMenuItem("Consulta pelicula por genero");
        ConsultasMenu.add(consultaGenero);
        AltasMenu.add(altaFuncion);
        AltasMenu.add(altaPelicula);

        //Asocio los actionListeners a sus respectivos items:
        altaFuncion.addActionListener(this);
        altaPelicula.addActionListener(this);
        consultaGenero.addActionListener(this);





    }

    /*Creación del metodo main para arrancar el programa desde aquí*/
    public static void main(String[] args) {

        //Creo una instancia de este frame:
        MenuPrincipal menuPrincipal = new MenuPrincipal("Menu Principal del Cine");

        //Vuelvo visible la instancia:
        menuPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Defino acciones cuando hago clic en el item de AltaFuncion:
        if (e.getSource()==altaFuncion){
            //todo: Agregar invocacion a la ventana donde se hace el alta de una función.
        }

        //Defino acciones cuando hago clic en el item de AltaPelicula:
        if (e.getSource()==altaPelicula){
            //todo: Agregar invocacion a la ventana donde se hace el alta de una pelicula.
        }

        if(e.getSource()==consultaGenero){

            ConsultaPelicula consultaPelicula =  new ConsultaPelicula();
            consultaPelicula.setVisible(true);

        }


    }
}
