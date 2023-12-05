/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.domain;

/**
 * The Telefono.
 *
 * @author Programacion Avanzada.
 */
public final class Telefono {

    /**
     * The numero.
     */
    private final String numero;

    /**
     * The Codigo de Area.
     */
    private final int codigoArea;

    /**
     * The tipo de telefono.
     */
    private final TipoTelefono tipoTelefono;

    /**
     * The Telefono.
     *
     * @param numero       de telefono.
     * @param codigoArea   de telefono.
     * @param tipoTelefono de telefono.
     */
    public Telefono(String numero, int codigoArea, TipoTelefono tipoTelefono) {
        this.numero = numero;
        this.codigoArea = codigoArea;
        this.tipoTelefono = tipoTelefono;
    }

    /**
     * @return the Numero.
     */
    public String getNumero() {
        return this.numero;
    }

    /**
     * @return the CodigoArea.
     */
    public int getCodigoArea() {
        return this.codigoArea;
    }

    /**
     * @return the TipoTelefono.
     */
    public TipoTelefono getTipoTelefono() {
        return this.tipoTelefono;
    }

}
