package view;

import controllers.FuncionController;
import dto.AltaFuncionDTO;

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

    private JMenuItem Terror, Drama,Romance,Biografica,Suspenso;

    private AltaFuncionDTO dto;



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
        Terror = new JMenuItem("Terror");
        Drama = new JMenuItem("Drama");
        Romance = new JMenuItem("Romance");
        Biografica = new JMenuItem("Biografica");
        Suspenso = new JMenuItem("Suspenso");
        generoMenu.add(Terror);
        generoMenu.add(Drama);
        generoMenu.add(Romance);
        generoMenu.add(Biografica);
        generoMenu.add(Suspenso);

        //Agrego los actionListener para cada item y botón:
        sucursal1.addActionListener(this);
        sucursal2.addActionListener(this);
        sucursal3.addActionListener(this);
        salaA.addActionListener(this);
        salaB.addActionListener(this);
        salaC.addActionListener(this);
        Terror.addActionListener(this);
        Drama.addActionListener(this);
        Romance.addActionListener(this);
        Biografica.addActionListener(this);
        Suspenso.addActionListener(this);
        aceptarButton.addActionListener(this);
        cancelarButton.addActionListener(this);

        //Instancio el DTO para esta vista:
        dto = new AltaFuncionDTO();
    }

    //Implemento el método actionPerformed y defino qué debe hacer cada item
    @Override
    public void actionPerformed(ActionEvent e) {

        //Defino las acciones para los items de las sucursales:
        if (e.getSource()==sucursal1){
            dto.setSucursal(sucursal1.getText());
            JOptionPane.showMessageDialog(null,"¡Sucursal 1 agregada!");
        }
        if (e.getSource()==sucursal2){
            dto.setSucursal(sucursal2.getText());
            JOptionPane.showMessageDialog(null,"¡Sucursal 2 agregada!");
        }

        if (e.getSource()==sucursal3){
            dto.setSucursal(sucursal3.getText());
            JOptionPane.showMessageDialog(null,"¡Sucursal 3 agregada!");
        }

        //Defino las acciones para los items de las salas:
        if (e.getSource()==salaA){
            dto.setSucursal(salaA.getText());
            JOptionPane.showMessageDialog(null,"¡Sala A agregada!");
        }

        if (e.getSource()==salaB){
            dto.setSucursal(salaB.getText());
            JOptionPane.showMessageDialog(null,"¡Sala B agregada!");
        }

        if (e.getSource()==salaC){
            dto.setSucursal(salaC.getText());
            JOptionPane.showMessageDialog(null,"¡Sala C agregada!");
        }

        //Defino las acciones para los items de los géneros:
        if (e.getSource()== Terror){
            dto.setSucursal(Terror.getText());
            JOptionPane.showMessageDialog(null,"¡Género Terror agregado!");
        }

        if (e.getSource()== Drama){
            dto.setSucursal(Drama.getText());
            JOptionPane.showMessageDialog(null,"¡Género Drama agregado!");
        }

        if (e.getSource()== Romance){
            dto.setSucursal(Romance.getText());
            JOptionPane.showMessageDialog(null,"¡Género Romance agregado!");
        }

        if (e.getSource()== Biografica){
            dto.setSucursal(Biografica.getText());
            JOptionPane.showMessageDialog(null,"¡Género Biografica agregado!");
        }

        if (e.getSource()== Suspenso){
            dto.setSucursal(Suspenso.getText());
            JOptionPane.showMessageDialog(null,"¡Género Suspenso agregado!");
        }


        //Defino las acciones para el botón Aceptar
        if (e.getSource()==aceptarButton){
            dto.setHorario(horarioTextField.getText());
            //todo: ----> Llamar al método que tenga el FuncionController para el alta de una función <-----
        }

        //Defino las acciones para el botón Cancelar:
        if (e.getSource()==cancelarButton){
            dto.setSucursal("");
            dto.setSala("");
            dto.setGenero("");
            dto.setHorario("");

            JOptionPane.showMessageDialog(null,"Operación Cancelada! Ingrese nuevamente los datos");
        }
    }
}
