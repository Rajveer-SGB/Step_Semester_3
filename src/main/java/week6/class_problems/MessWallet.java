package week6.class_problems;

public class MessWallet {

    private double balance;

    public MessWallet(double openingBalance) {

        if (openingBalance < 0) {

            System.out.println(
                    "Warning: Negative opening balance. Starting at 0."
            );

            balance = 0;

        } else {

            balance = openingBalance;
        }
    }

    public void topUp(double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Top-up rejected: Invalid amount"
            );

            return;
        }

        balance += amount;

        System.out.println(
                "Balance after top-up: " + balance
        );
    }

    public void deduct(double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Deduct rejected: Invalid amount"
            );

            return;
        }

        if (amount > balance) {

            System.out.println(
                    "Deduct rejected: insufficient balance"
            );

            return;
        }

        balance -= amount;

        System.out.println(
                "Balance after deduction: " + balance
        );
    }

    public double getBalance() {

        return balance;
    }

    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);

        wallet.deduct(1000);

        System.out.println(
                "Final balance: " + wallet.getBalance()
        );
    }
}
