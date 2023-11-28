/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.ui;

import cl.ucn.disc.poo.agenda.services.Agenda;
import cl.ucn.disc.poo.agenda.services.AgendaImpl;

/**
 * The Singleton of Agenda.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class AgendaSingleton {

    /**
     * The Singleton.
     */
    private static final Agenda INSTANCE = new AgendaImpl();

    /**
     * Empty constructor.
     */
    private AgendaSingleton() {
        // nothing
    }

    /**
     * @return the Agenda.
     */
    public static Agenda getInstance() {
        return INSTANCE;
    }

}
