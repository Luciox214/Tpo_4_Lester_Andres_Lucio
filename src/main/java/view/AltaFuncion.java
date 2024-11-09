package view;

import controllers.FuncionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaFuncion extends JFrame implements ActionListener {
    private JPanel pnlPrincipal;
    private JPanel pnlTituloAltaFuncion;
    private JLabel TituloLabel;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel pnlCentral;
    private JPanel pnlLabels;
    private JPanel pnlMenus;
    private JMenuBar barraMenuSucursales;
    private JLabel sucursalLabel;
    private JLabel salaLabel;
    private JLabel generoLabel;
    private JLabel horarioLabel;
    private JMenuBar barraMenuSalas;
    private JMenu sucursalesMenu;
    private JMenu salaMenu;
    private JMenuBar barraMenuGenero;
    private JMenu generoMenu;
    private JTextField horarioTextField;

    private JMenuItem sucursal1,sucursal2,sucursal3;

    private JMenuItem salaA,salaB,salaC;

    private JMenuItem generoMasculino,generoFemenino;





    //Variable de tipo controller:
    FuncionController funcionController; //Falta instanciar esta variable del controlador.

    //Constructor:
    public AltaFuncion(String titulo){

        /*CONFIGURACIÓN BÁSICA*/

        // 1) Asigno el titulo a este frame con el constructor de la clase padre JFrame:
        super(titulo);

        // 2) Asigno el panel principal a este frame:
        setContentPane(pnlPrincipal);

        // 3) Asigno el tamaño por defecto de esta ventana:
        setSize(600,300);

        // 4) Establezco el comportamiento por defecto al cerrar la ventana:
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        /*INSTANCIACIÓN DE ITEMS Y SU ASOCIACIÓN CON LOS MENÚS*/

        //Instancio los items del menu de sucursales y los agrego al mismo:
        sucursal1 = new JMenuItem("Sucursal 1");
        sucursal2 = new JMenuItem("Sucursal 2");
        sucursal3 = new JMenuItem("Sucursal 3");
        sucursalesMenu.add(sucursal1);
        sucursalesMenu.add(sucursal2);
        sucursalesMenu.add(sucursal3);

        //Instancio los items del menú de salas y los agrego al mismo:
        salaA = new JMenuItem("Sala A");
        salaB = new JMenuItem("Sala B");
        salaC = new JMenuItem("Sala C");
        salaMenu.add(salaA);
        salaMenu.add(salaB);
        salaMenu.add(salaC);

        //Instancio los items del menú de generos y los agrego al mismo:
        generoMasculino = new JMenuItem("Masculino");
        generoFemenino = new JMenuItem("Femenino");
        generoMenu.add(generoMasculino);
        generoMenu.add(generoFemenino);
    }

    //Implemento el método actionPerformed y defino qué debe hacer cada item
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==sucursal1){

        }
    }
}
