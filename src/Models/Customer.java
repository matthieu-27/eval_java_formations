package Models;

import java.util.ArrayList;


/**
 * Classe représentant un client (destinataire d'une commande)
 * @author Matthieu Couderc
 * @version 1.0
 */
public class Customer {

        private int id;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String phone;

        public static ArrayList<Customer> customersList = new ArrayList<>();

        /**
         * Constructeur complet pour un client
         * @param id: identifiant unique
         * @param firstName: prénom du client
         * @param lastName: nom du client
         * @param email: email du client
         * @param address: adresse complète du client
         * @param phone: numéro de téléphone
         */
        public Customer(int id, String firstName, String lastName, String email, String address, String phone) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.address = address;
            this.phone = phone;
            customersList.add(this);
        }

        /**
         * Constructeur pour création de client (sans id)
         */
        public Customer(String firstName, String lastName, String email, String address, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.address = address;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }

        /* GETTERS AND SETTERS */

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


}
