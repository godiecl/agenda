/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.domain.Contacto;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The Contacto Dialog.
 *
 * @author Diego Urrutia-Astorga.
 */
public class ContactoDialog extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textRut;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textCalle;
    private JTextField textCiudad;
    private JTextField textCodigoPostal;
    private JTextField textCodigoArea;
    private JTextField textNumero;

    private AgendaModel agendaModel;

    /**
     * The Constructor.
     *
     * @param agendaModel to use.
     */
    public ContactoDialog(final AgendaModel agendaModel) {
        this.agendaModel = agendaModel;
        // titulo del formulario
        this.setTitle("Información de Contacto");
        // contenido del formulario
        this.setContentPane(contentPane);
        // formulario bloque el acceso a la ventana de atras
        this.setModal(true);
        // boton por defecto es el cancelar
        this.getRootPane()
                .setDefaultButton(buttonCancel);

        // call onOK() on ESCAPE
        this.buttonOK.addActionListener(e -> this.onOK());

        // call onCancel() on ESCAPE
        this.buttonCancel.addActionListener(e -> this.onCancel());

        // call onCancel() when cross is clicked
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        this.contentPane.registerKeyboardAction(e -> this.onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Al momento de presionar OK.
     */
    private void onOK() {

        // cajita de rut, nombre y apellido con datos
        if (!this.textRut.getText().trim().isEmpty()
                && !this.textNombre.getText().trim().isEmpty()
                && !this.textApellido.getText().trim().isEmpty()) {

            // construccion del contacto
            Contacto contacto = Contacto.builder()
                    .rut(this.textRut.getText().trim())
                    .nombre(this.textNombre.getText().trim())
                    .apellido(this.textApellido.getText().trim())
                    .build();

            // agrego el contacto al model
            this.agendaModel.add(contacto);

            // cierro la ventana
            dispose();
        }

    }

    /**
     * Al momento de presionar Cancel.
     */
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
