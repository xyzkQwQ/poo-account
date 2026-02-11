package fr.afpa.account;

/**
 * Classe représentant un compte bancaire
 */
import java.math.BigInteger;

public class Account {

    private String iban;
    private int balance;
    private int overdraftAuthorization;

    // Constructeur
    public Account(String iban, int balance, int overdraftAuthorization) {
        if (checkIban(iban)) {
            this.iban = iban;
        } else {
            System.out.println("IBAN invalide !");
            this.iban = null;
        }
        this.balance = balance;
        this.overdraftAuthorization = overdraftAuthorization;
    }

    // Getters
    public String getIban() {
        return iban;
    }

    public int getBalance() {
        return balance;
    }

    public int getOverdraftAuthorization() {
        return overdraftAuthorization;
    }

    // Setters
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setOverdraftAuthorization(int overdraftAuthorization) {
        this.overdraftAuthorization = overdraftAuthorization;
    }

    // Ajouter de l'argent
    public void addMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Retirer de l'argent
    public boolean removeMoney(int amount) {
        if (amount > 0 && balance - amount >= -overdraftAuthorization) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Retrait impossible : découvert dépassé !");
            return false;
        }
    }

    // Transfert
    public void transfer(Account otherAccount, int amount) {
        if (this.removeMoney(amount)) {
            otherAccount.addMoney(amount);
        }
    }

    // Vérification IBAN (méthode static)
    public static boolean checkIban(String stringToCheck) {

        if (stringToCheck == null) return false;

        String iban = stringToCheck.replaceAll(" ", "").toUpperCase();

        if (iban.length() < 15 || iban.length() > 34) return false;

        String rearranged = iban.substring(4) + iban.substring(0, 4);

        StringBuilder numericIban = new StringBuilder();

        for (char c : rearranged.toCharArray()) {
            if (Character.isLetter(c)) {
                numericIban.append(c - 55);
            } else {
                numericIban.append(c);
            }
        }

        BigInteger bigInt = new BigInteger(numericIban.toString());
        return bigInt.mod(BigInteger.valueOf(97)).intValue() == 1;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                ", overdraftAuthorization=" + overdraftAuthorization +
                '}';
    }
}

