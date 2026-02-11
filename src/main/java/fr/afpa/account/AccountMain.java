package fr.afpa.account;

/**
 * Classe principale du projet, contient la fonction "main"
 */
public class AccountMain {

    public static void main(String[] args) {

        // Test IBAN
        System.out.println(Account.checkIban("FR7630001007941234567890185"));

        // Création comptes
        Account acc1 = new Account("FR7630001007941234567890185", 1000, 200);
        Account acc2 = new Account("FR1420041010050500013M02606", 500, 100);

        // Test opérations
        acc1.addMoney(200);
        acc1.removeMoney(300);
        acc1.transfer(acc2, 400);

        System.out.println(acc1);
        System.out.println(acc2);

        // Création client
        Customer customer1 = new Customer(1, "Jean", "Dupont");

        // Association comptes
        customer1.addAccount(acc1);
        customer1.addAccount(acc2);

        System.out.println(customer1);

        // Suppression d’un compte
        customer1.removeAccount(acc2);

        System.out.println("Après suppression :");
        System.out.println(customer1);
    }
}
