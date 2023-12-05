/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.domain;

/**
 * The Direccion.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class Direccion {

    /**
     * The calle.
     */
    private final String calle;

    /**
     * The codigo postal.
     */
    private final int codigoPostal;

    /**
     * The ciudad.
     */
    private final String ciudad;

    /**
     * The Direccion.
     *
     * @param calle        de la direccion.
     * @param codigoPostal de la direccion.
     * @param ciudad       de la direccion.
     */
    public Direccion(String calle, int codigoPostal, String ciudad) {
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    /**
     * @return the Calle.
     */
    public String getCalle() {
        return this.calle;
    }

    /**
     * @return the CodigoPostal.
     */
    public int getCodigoPostal() {
        return this.codigoPostal;
    }

    /**
     * @return the Ciudad.
     */
    public String getCiudad() {
        return this.ciudad;
    }
}
