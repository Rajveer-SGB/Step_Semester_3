package week7.class_problems;

public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        savings += amount;
        System.out.println("Savings = " + savings);
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            System.out.println("Withdrawal rejected");
            return;
        }

        savings -= amount;
        System.out.println("Savings = " + savings);
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings: " + pb.getSavings());
    }
}