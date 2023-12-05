/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.services;

import cl.ucn.disc.poo.agenda.domain.Contacto;

import java.util.List;

/**
 * Operaciones de la Agenda.
 *
 * @author Diego Urrutia-Astorga.
 */
public interface Agenda {

    /**
     * Agrega un Contacto a la Agenda.
     *
     * @param contacto a agregar.
     */
    void add(Contacto contacto);

    /**
     * Busqueda de Contactos a partir de sus letras.
     *
     * @param letras a buscar.
     * @return List of Contacts.
     */
    List<Contacto> search(String letras);

    /**
     * @return todos los Contactos de la Agenda.
     */
    List<Contacto> getContactos();

    /**
     * @return el numero de contactos en la Agenda.
     */
    int size();

    /**
     * Retorna el Contacto en la posicion indicada.
     *
     * @param posicion del contacto.
     * @return the Contacto.
     */
    Contacto getContacto(int posicion);

    /**
     * Retorna el Contacto dado su rut.
     *
     * @param rut del contacto.
     * @return the Contacto.
     */
    Contacto getContacto(String rut);

    /**
     * Carga desde el backend los Contactos.
     */
    void load();

    /**
     * Guarda en el backend los Contactos.
     */
    void save();

}
