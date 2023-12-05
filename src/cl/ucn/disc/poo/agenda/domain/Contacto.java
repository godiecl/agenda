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
     * The rut.
     */
    private String rut;

    /**
     * The nombre.
     */
    private String nombre;

    /**
     * The apellido.
     */
    private String apellido;

    /**
     * The telefono.
     */
    private Telefono telefono;

    /**
     * The direccion.
     */
    private Direccion direccion;

    /**
     * The Contacto.
     */
    private Contacto() {
        // nothing here
    }

    /**
     * @return the Rut.
     */
    public String getRut() {
        return this.rut;
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
    public Telefono getTelefono() {
        return this.telefono;
    }

    /**
     * @return the direccion.
     */
    public Direccion getDireccion() {
        return this.direccion;
    }

    /**
     * @return the nombre + apellido.
     */
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    /**
     * The builder pattern.
     *
     * @return the builder.
     */
    public static ContactoBuilder builder() {
        return new ContactoBuilder();
    }

    /**
     * The Builder pattern.
     */
    public static class ContactoBuilder {

        /**
         * The Rut.
         */
        private String rut;

        /**
         * The nombre.
         */
        private String nombre;

        /**
         * The apellido.
         */
        private String apellido;

        /**
         * The telefono.
         */
        private Telefono telefono;

        /**
         * The direccion.
         */
        private Direccion direccion;

        /**
         * @param rut to use.
         * @return the ContactoBuilder.
         */
        public ContactoBuilder rut(String rut) {
            this.checkNull(rut, "RUT no puede ser null");
            this.rut = rut.toLowerCase()
                          .trim();
            return this;
        }

        /**
         * @param nombre to use.
         * @return the ContactoBuilder.
         */
        public ContactoBuilder nombre(String nombre) {
            this.nombre = nombre.toLowerCase()
                                .trim();
            return this;
        }

        /**
         * @param apellido to use.
         * @return the ContactoBuilder.
         */
        public ContactoBuilder apellido(String apellido) {
            this.apellido = apellido.toLowerCase()
                                    .trim();
            return this;
        }

        /**
         * @param telefono to use.
         * @return the ContactoBuilder.
         */
        public ContactoBuilder telefono(Telefono telefono) {
            this.telefono = telefono;
            return this;
        }

        /**
         * @param direccion to use.
         * @return the ContactoBuilder.
         */
        public ContactoBuilder direccion(Direccion direccion) {
            this.direccion = direccion;
            return this;
        }

        /**
         * @return the Contacto.
         */
        public Contacto build() {

            // The validations
            if (this.rut == null) {
                throw new NullPointerException("rut");
            }

            if (this.nombre == null) {
                throw new NullPointerException("nombre");
            }

            if (this.apellido == null) {
                throw new NullPointerException("apellido");
            }

            // The instance
            Contacto contacto = new Contacto();

            contacto.rut = this.rut;
            contacto.nombre = this.nombre;
            contacto.apellido = this.apellido;
            contacto.telefono = this.telefono;
            contacto.direccion = this.direccion;

            return contacto;
        }

        /**
         * Check nullity.
         */
        private void checkNull(String value, String message) {
            if (value == null) {
                throw new NullPointerException(message);
            }
        }
    }

}
