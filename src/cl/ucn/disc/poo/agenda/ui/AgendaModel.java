/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.domain.Contacto;
import cl.ucn.disc.poo.agenda.services.Agenda;

import javax.swing.table.AbstractTableModel;

/**
 * The Agenda Model.
 *
 * @author Programacion Avanzada.
 */
public final class AgendaModel extends AbstractTableModel {

    /**
     * The Agenda.
     */
    private final Agenda agenda;

    /**
     * The Constructor.
     *
     * @param agenda to use.
     */
    public AgendaModel(Agenda agenda) {
        this.agenda = agenda;
    }

    /**
     * Returns the number of rows in the model.
     */
    @Override
    public int getRowCount() {
        return this.agenda.getContactos()
                          .size();
    }

    /**
     * Returns the number of columns in the model.
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     * @return a string containing the default name of <code>column</code>
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Apellido";
            case 2:
                return "Telefono";
        }
        throw new IndexOutOfBoundsException("Columna invalida.");
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        // el contacto en la agenda
        Contacto contacto = this.agenda.getContactos()
                                       .get(rowIndex);

        switch (columnIndex) {
            case 0:
                return contacto.getNombre();
            case 1:
                return contacto.getApellido();
            case 2:
                return contacto.getTelefono();
        }

        throw new IndexOutOfBoundsException("Fila o columna invalida.");
    }

    /**
     * Returns the Contacto at <code>rowIndex</code>.
     */
    public Contacto getContacto(int rowIndex) {
        if (rowIndex < 0) {
            return null;
        }
        return this.agenda.getContactos()
                          .get(rowIndex);
    }

    /**
     * Agrega un Contacto a la Agenda.
     */
    public void add(final Contacto contacto) {
        this.agenda.add(contacto);
        this.fireTableDataChanged();
    }
}
