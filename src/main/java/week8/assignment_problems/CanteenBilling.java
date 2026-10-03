package week8.assignment_problems;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double finalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super(amount);
    }

    @Override
    double finalAmount() {
        return amount * 0.90;
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super(amount);
    }

    @Override
    double finalAmount() {
        return amount * 0.95;
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super(amount);
    }

    @Override
    double finalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {

        Customer[] customers = {
            new StudentCustomer(200),
            new StaffCustomer(300),
            new GuestCustomer(150)
        };

        String[] types = {
            "STUDENT",
            "STAFF",
            "GUEST"
        };

        double total = 0;

        for (int i = 0; i < customers.length; i++) {
            double amount = customers[i].finalAmount();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                amount
            );

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}