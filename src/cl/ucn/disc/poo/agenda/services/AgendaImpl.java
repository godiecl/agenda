/*
 * Copyright (c) 2023. Programacion Orientada al Objeto, DISC, UCN.
 */

package cl.ucn.disc.poo.agenda.services;

import cl.ucn.disc.poo.agenda.domain.Contacto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Implementacion concreta de la Agenda.
 *
 * @author Diego Urrutia-Astorga.
 */
public final class AgendaImpl implements Agenda {

    /**
     * Nombre del archivo.
     */
    private static final String FILENAME = "contactos.json";

    /**
     * Procesador de JSON.
     */
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Listado de Contactos.
     */
    private final List<Contacto> contactos = new ArrayList<>();

    /**
     * The constructor.
     */
    public AgendaImpl() {

        // al momento de crear la Agenda, se cargan los contactos.
        try {
            this.load();
        } catch (RuntimeException ex) {
            // no se encontro el archivo, sera creado
            this.save();
        }

        // sort the contacts.
        this.sort();
    }

    /**
     * Ordena los contactos por appellido.
     */
    private void sort() {
        // ordenamiento por apellido
        this.contactos.sort(Comparator.comparing(Contacto::getApellido));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(final Contacto contacto) {

        // validation: nullity
        if (contacto == null) {
            throw new IllegalArgumentException("Contacto no puede ser null");
        }

        // don't allow repeated Contact.
        if (this.contactos.stream()
                .anyMatch(c -> this.isEquals(c, contacto))) {
            System.out.println("Contacto ya existe, no fue agregado.");
            return;
        }

        // agrego al listado
        this.contactos.add(contacto);

        // ordeno
        this.sort();

        // guardo
        this.save();
    }

    /**
     * Two contacts are equals?
     *
     * @param c1 contacto.
     * @param c2 contacto.
     * @return true si el nombre, apellido y numero es igual.
     */
    private boolean isEquals(final Contacto c1, final Contacto c2) {
        return c1.getRut()
                .equalsIgnoreCase(c2.getRut());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Contacto> search(final String letras) {

        // listado de resultados
        List<Contacto> result = new ArrayList<>();

        // misma version de arriba, pero usando stream
        List<Contacto> contactosFiltrados = this.contactos
                .stream()
                .filter(c -> c.getNombreCompleto().equalsIgnoreCase(letras))
                .toList();

        // retorno el resultado
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Contacto> getContactos() {
        // retorno una lista que no puede ser modificada
        // (solo se puede actualizar mediante el load y add)
        return Collections.unmodifiableList(this.contactos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.contactos.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contacto getContacto(int posicion) {
        return this.contactos.get(posicion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Contacto getContacto(String rut) {
        return this.contactos
                .stream()
                .filter(c -> c.getRut().equalsIgnoreCase(rut))
                .findFirst().orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load() {

        // limpiar la lista previo a la carga
        this.contactos.clear();

        // leer desde el archivo FILENAME los contactos.
        try {
            // lectura de json -> contacto[]
            Contacto[] arregloContactos = GSON.fromJson(new FileReader(FILENAME), Contacto[].class);

            // agrego el arreglo de contactos al listado
            this.contactos.addAll(Arrays.asList(arregloContactos));

        } catch (FileNotFoundException e) {
            // algun problema en la lectura del archivo
            throw new RuntimeException("Error de lectura", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save() {

        // escribir en el archivo FILENAME los contactos.
        try (FileWriter writer = new FileWriter(FILENAME)) {
            GSON.toJson(this.contactos, writer);
        } catch (IOException e) {
            // algun problema en la escritura del archivo
            throw new RuntimeException("Error de escritura", e);
        }
    }
}
