/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda;

import cl.ucn.disc.poo.agenda.domain.Contacto;
import cl.ucn.disc.poo.agenda.services.Agenda;
import cl.ucn.disc.poo.agenda.services.AgendaImpl;

/**
 * The Main.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class TheAgenda {

    /**
     * The main.
     */
    public static void main(String[] args) {

        System.out.println("Starting the Agenda ..");

        // mi agenda.
        Agenda agenda = new AgendaImpl();

        agenda.add(new Contacto("Francisco", "Urtuza", "+569 8765 4321"));

        for (Contacto c : agenda.getContactos()) {
            System.out.println("Contacto: " + c.getNombreCompleto());
        }

        for (Contacto c : agenda.search("p")) {
            System.out.println("Encontrados: " + c.getNombreCompleto());
        }

        System.out.println("Done.");

    }

}
