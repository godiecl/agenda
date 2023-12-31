/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.domain.Contacto;
import cl.ucn.disc.poo.agenda.domain.Direccion;
import cl.ucn.disc.poo.agenda.domain.Telefono;

import javax.swing.table.AbstractTableModel;

/**
 * The Agenda Model.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class AgendaModel extends AbstractTableModel {

    /**
     * The Constructor.
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
        return 4;
    }

    /**
     * @return a string containing the default name of <code>column</code>
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "RUT";
            case 1:
                return "Nombre";
            case 2:
                return "Telefono";
            case 3:
                return "Direccion";
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

        // dependiendo de la columna, retorno el valor
        switch (columnIndex) {
            case 0:
                return contacto.getRut();
            case 1:
                return contacto.getNombreCompleto();
            case 2:
                Telefono telefono = contacto.getTelefono();
                if (telefono != null) {
                    return "+" + telefono.getCodigoArea() + telefono.getNumero();
                }
                return null;
            case 3:
                Direccion direccion = contacto.getDireccion();
                if (direccion != null) {
                    return direccion.getCalle() + " (" + direccion.getCiudad() + ")";
                }
                return null;
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
