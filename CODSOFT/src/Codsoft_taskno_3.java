import java.util.Scanner;

public class Codsoft_taskno_3 {
    private int balance;

    public Codsoft_taskno_3() {
        this.balance = 0;
    }

    public void startATM() {
        Scanner scanner = new Scanner(System.in);
        boolean continueTransactions = true;

        while (continueTransactions) {
            displayMenu();
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    continueTransactions = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw(int amount) {
        if (amount <= this.balance && amount > 0) {
            this.balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount for withdrawal.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: " + this.balance);
    }

    public static void main(String[] args) {
        Codsoft_taskno_3 atm = new Codsoft_taskno_3();
        atm.startATM();
    }
}
