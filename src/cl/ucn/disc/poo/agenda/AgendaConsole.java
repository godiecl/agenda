/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda;

import cl.ucn.disc.poo.agenda.domain.Contacto;
import cl.ucn.disc.poo.agenda.domain.Direccion;
import cl.ucn.disc.poo.agenda.domain.Telefono;
import cl.ucn.disc.poo.agenda.domain.TipoTelefono;
import cl.ucn.disc.poo.agenda.services.Agenda;
import cl.ucn.disc.poo.agenda.services.AgendaImpl;

/**
 * The Main.
 *
 * @author Programacion Orientada al Objeto.
 */
public final class AgendaConsole {

    /**
     * The main.
     */
    public static void main(String[] args) {

        System.out.println("Starting the Agenda ..");

        // mi agenda.
        Agenda agenda = new AgendaImpl();

        // agregar contactos.
        agenda.add(Contacto.builder()
                           .rut("99999999-9")
                           .nombre("Francisco")
                           .apellido("Urtuza")
                           .telefono(new Telefono("9 8765 4321", 56, TipoTelefono.MOVIL))
                           .build());

        agenda.add(Contacto.builder()
                           .rut("88888888-8")
                           .nombre("Javiera")
                           .apellido("Paredes")
                           .telefono(new Telefono("9 1234 5678", 56, TipoTelefono.MOVIL))
                           .build());

        agenda.add(Contacto.builder()
                           .rut("77777777-7")
                           .nombre("Carmen")
                           .apellido("Astorga")
                           .direccion(new Direccion("Angamos #0610", 127001, "Antofagasta"))
                           .build());

        // mostrar los contactos.
        for (Contacto c : agenda.getContactos()) {
            System.out.println("Contacto: " + c.getNombreCompleto());
        }

        // buscar contactos.
        for (Contacto c : agenda.search("p")) {
            System.out.println("Encontrados: " + c.getNombreCompleto());
        }

        // buscar contacto
        Contacto contacto = agenda.getContacto("99999999-9");
        if (contacto != null) {
            System.out.println("Encontrados: " + contacto.getNombreCompleto());
        }

        System.out.println("Done.");

    }

}
