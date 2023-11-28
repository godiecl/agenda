/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.domain.Contacto;

import javax.swing.table.AbstractTableModel;

/**
 * The Agenda Model.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class AgendaModel extends AbstractTableModel {

    /**
     * The Constructor.
     *
     * @param agenda to use.
     */
    public AgendaModel() {
        // nothing here
    }

    /**
     * Returns the number of rows in the model.
     */
    @Override
    public int getRowCount() {
        return AgendaSingleton.getInstance()
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
        Contacto contacto = AgendaSingleton.getInstance()
                                           .getContacto(rowIndex);

        // depeniendo de la columna, retorno el valor
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
        return AgendaSingleton.getInstance()
                              .getContacto(rowIndex);
    }

    /**
     * Agrega un Contacto a la Agenda.
     */
    public void add(final Contacto contacto) {
        // agrego el contacto a al Agenda.
        AgendaSingleton.getInstance()
                       .add(contacto);
        // notifico a la tabla que se agrego un contacto.
        this.fireTableDataChanged();
    }
}
