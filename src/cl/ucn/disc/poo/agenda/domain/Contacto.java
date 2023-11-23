/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.domain;

/**
 * Contacto de una Agenda Telefonica.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class Contacto {

    /**
     * The nombre.
     */
    private final String nombre;

    /**
     * The apellido.
     */
    private final String apellido;

    /**
     * The numero telefonico ej: +56 2 2355166
     */
    private final String telefono;

    /**
     * The Contacto.
     *
     * @param nombre   del contacto.
     * @param apellido del contacto.
     * @param telefono del contacto.
     */
    public Contacto(final String nombre, final String apellido, final String telefono) {
        // FIXME: agregar validaciones
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    /**
     * @return the nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the apellido.
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * @return the telefono.
     */
    public String getTelefono() {
        return this.telefono;
    }

    /**
     * @return the nombre + apellido.
     */
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

}
