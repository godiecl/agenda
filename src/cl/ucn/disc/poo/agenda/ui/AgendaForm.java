/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.services.Agenda;
import cl.ucn.disc.poo.agenda.services.AgendaImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Implementacion del Formulario de la Agenda.
 *
 * @author Programacion Orientada al Objeto.
 */
public final class AgendaForm extends JFrame {

    private JPanel panelMain;
    private JPanel panelStatus;
    private JLabel labelNumeroContactos;
    private JPanel panelCenter;
    private JPanel panelTitle;
    private JTable tableContactos;

    /**
     * The Agenda Model.
     */
    private final AgendaModel agendaModel;

    /**
     * Constructor de la agenda.
     */
    public AgendaForm(final Agenda agenda) {
        super("Agenda v1.0");

        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // tamanio de la ventana
        Dimension dimension = this.getToolkit()
                                  .getScreenSize();

        // centrado en la pantalla
        this.setBounds(dimension.width / 4, dimension.height / 4, dimension.width / 2, dimension.height / 2);

        // asigno la agenda
        this.agendaModel = new AgendaModel(agenda);

        // asigno el modelo a la tabla
        this.tableContactos.setModel(this.agendaModel);
    }

    /**
     * Update the status.
     */
    public void updateStatus() {
        this.labelNumeroContactos.setText(Integer.toString(this.agendaModel.getRowCount()));
    }

    /**
     * The main.
     */
    public static void main(String[] args) {

        // Look & feel
        try {
            // windows rulez
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

            // color de las filas alternadas
            UIDefaults defaults = UIManager.getLookAndFeelDefaults();
            if (defaults.get("Table.alternateRowColor") == null) {
                defaults.put("Table.alternateRowColor", new Color(240, 240, 240));
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        // creacion de la agenda (fuera del hilo de dibujo)
        Agenda agenda = new AgendaImpl();

        // SwingUtilities
        SwingUtilities.invokeLater(() -> {

            // creo la agenda
            AgendaForm agendaForm = new AgendaForm(agenda);

            // la hago visible
            agendaForm.setVisible(true);

            // actualizo el estado
            agendaForm.updateStatus();
        });

    }
}
