/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.services.Agenda;
import cl.ucn.disc.poo.agenda.services.AgendaImpl;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

/**
 * The Agenda.
 *
 * @author Programacion Avanzada.
 */
public final class AgendaVentana extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JButton buttonAgregar;
    private JPanel panelStatus;
    private JLabel labelStatus;
    private JLabel labelNumeroContactos;
    private JTable tableContactos;
    private JTextField textBusqueda;

    /**
     * The Model of Table.
     */
    private final AgendaModel agendaModel;

    /**
     * The Constructor.
     *
     * @param agenda to use.
     */
    public AgendaVentana() {

        // el titulo de la ventana
        super("Agenda v3.0.0");

        // configuration de la pantalla
        this.setContentPane(this.panelPrincipal);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // modelo de la tabla
        this.agendaModel = new AgendaModel();
        // asigno el modelo a la tabla
        this.tableContactos.setModel(this.agendaModel);

        // dialog para agregar un contacto
        this.buttonAgregar.addActionListener(e -> {
            ContactoDialog cd = new ContactoDialog(this.agendaModel);
            cd.pack();
            cd.setLocationRelativeTo(null);
            cd.setVisible(true);
        });

    }

    /**
     * Actualiza la barrita de contacto.
     */
    public void actualizar() {
        this.labelNumeroContactos.setText(
                Integer.toString(this.agendaModel.getRowCount()));
    }

    /**
     * The Main.
     */
    public static void main(String[] args) {

        // construccion y carga de la agenda
        Agenda agenda = new AgendaImpl();

        // look & feel: https://www.formdev.com/flatlaf/
        FlatLightLaf.setup();

        // inicio de los elementos graficos
        SwingUtilities.invokeLater(() -> {

            // construccion de la ventana
            AgendaVentana av = new AgendaVentana();

            // actualiza la barra de estado
            av.actualizar();

            // ajusta el tamaño de la ventana
            av.pack();

            // centrar la ventana
            av.setLocationRelativeTo(null);

            // mostrar la ventana
            av.setVisible(true);

        });

    }

}
