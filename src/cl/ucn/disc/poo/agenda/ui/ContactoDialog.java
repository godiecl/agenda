/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

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

    private AgendaModel agendaModel;

    /**
     * The Constructor.
     *
     * @param agendaModel to use.
     */
    public ContactoDialog(AgendaModel agendaModel) {
        this.agendaModel = agendaModel;
        this.setContentPane(contentPane);
        this.setModal(true);
        this.getRootPane()
            .setDefaultButton(buttonOK);

        // call onOK() on ESCAPE
        buttonOK.addActionListener(e -> onOK());

        // call onCancel() on ESCAPE
        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * Al momento de presionar OK.
     */
    private void onOK() {
        // add your code here
        dispose();
    }

    /**
     * Al momento de presionar Cancel.
     */
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
