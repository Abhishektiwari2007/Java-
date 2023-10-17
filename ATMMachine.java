import java.util.Scanner;

class ATM {
    private float balance = 0; 
    private final int PIN = 4345;
    private int attempts = 3; 

    public float getBalance() {
        return balance;
    }

    public void checkpin() {
        while (attempts > 0) {
            System.out.println("Enter your pin (" + attempts + " attempts remaining):");
            Scanner sc = new Scanner(System.in);
            int enterpin = sc.nextInt();
            if (enterpin == PIN) {
                menu();
                break; // Correct PIN, exit the loop
            } else {
                System.out.println("Incorrect PIN. Please try again.");
                attempts--;
            }
        }
        System.out.println("Exceeded maximum PIN attempts. Exiting.");
    }

    public void menu() {
        System.out.println("Enter Your Choice: ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdrawMoney();
        } else if (opt == 3) {
            depositMoney();
        } else if (opt == 4) {
            System.out.println("Thank you for using the ATM.");
            System.exit(0);
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + getBalance());
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter the amount to Withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > getBalance()) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Money Withdrawal Successful");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the amount: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Money Deposited Successfully");
        menu();
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();
    }
}
