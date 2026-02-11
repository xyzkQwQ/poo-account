package fr.afpa.account;

/**
 * Classe qui représente un client, propriétaire de comptes bancaires
 */

import java.util.ArrayList;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts = new ArrayList<>();

    // Constructeur
    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    // Ajouter un compte
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Supprimer un compte
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

