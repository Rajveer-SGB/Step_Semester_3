package week8.class_problems;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + weight + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(
        double weight,
        double distance,
        double customsFee
    ) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (2 * weight)
                + (0.50 * distance)
                + customsFee;
    }
}

public class DeliveryFee {
    public static void main(String[] args) {

        Delivery[] deliveries = {
            new StandardDelivery(10, 50),
            new ExpressDelivery(5, 20),
            new InternationalDelivery(20, 100, 30)
        };

        String[] types = {
            "STANDARD",
            "EXPRESS",
            "INTERNATIONAL"
        };

        double total = 0;

        for (int i = 0; i < deliveries.length; i++) {
            double fee = deliveries[i].calculateFee();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                fee
            );

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}