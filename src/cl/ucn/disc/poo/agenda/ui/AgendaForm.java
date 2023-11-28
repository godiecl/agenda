/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.domain.Contacto;

import javax.swing.*;
import java.awt.*;

/**
 * Implementacion del Formulario de la Agenda.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class AgendaForm extends JFrame {

    private JPanel panelMain;
    private JPanel panelStatus;
    private JLabel labelNumeroContactos;
    private JPanel panelCenter;
    private JPanel panelTitle;
    private JTable tableContactos;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textTelefono;
    private JButton buttonGuardar;
    private JButton buttonLimpiar;

    /**
     * The Agenda Model.
     */
    private final AgendaModel agendaModel;

    /**
     * Constructor de la agenda.
     */
    public AgendaForm() {
        super("Agenda v2.0");

        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // tamanio de la ventana
        Dimension dimension = this.getToolkit()
                                  .getScreenSize();

        // centrado en la pantalla
        this.setBounds(dimension.width / 4, dimension.height / 4, dimension.width / 2, dimension.height / 2);

        // asigno la agenda
        this.agendaModel = new AgendaModel();

        // asigno el modelo a la tabla
        this.tableContactos.setModel(this.agendaModel);

        // en caso de seleccionar una fila, muestro los datos del contacto
        this.tableContactos.getSelectionModel()
                           .addListSelectionListener(e -> {

                               // si no hay seleccion, no hago nada
                               if (e.getValueIsAdjusting()) {
                                   return;
                               }

                               // obtengo el contacto seleccionado
                               Contacto contacto = agendaModel.getContacto(tableContactos.getSelectedRow());

                               // si no hay contacto, no hago nada
                               if (contacto == null) {
                                   return;
                               }

                               // muestro los datos del contacto
                               textNombre.setText(contacto.getNombre());
                               textApellidos.setText(contacto.getApellido());
                               textTelefono.setText(contacto.getTelefono());
                           });

        // limpiar el formulario
        this.buttonLimpiar.addActionListener(e -> {
            textNombre.setText("");
            textApellidos.setText("");
            textTelefono.setText("+569");
            this.tableContactos.getSelectionModel()
                               .clearSelection();
        });

        this.buttonGuardar.addActionListener(e -> {
            Contacto contacto = new Contacto(textNombre.getText(), textApellidos.getText(), textTelefono.getText());
            this.agendaModel.add(contacto);
        });
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

        // SwingUtilities
        SwingUtilities.invokeLater(() -> {

            // creo la agenda
            AgendaForm agendaForm = new AgendaForm();

            // la hago visible
            agendaForm.setVisible(true);

            // actualizo el estado
            agendaForm.updateStatus();
        });

    }
}
