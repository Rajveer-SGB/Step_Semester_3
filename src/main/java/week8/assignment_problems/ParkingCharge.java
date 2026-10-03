package week8.assignment_problems;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    @Override
    double calculateCharge() {
        return Math.max(hours * 50, 100);
    }
}

public class ParkingCharge {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
            new Bike(3),
            new Car(4),
            new Truck(1),
            new Car(1)
        };

        String[] types = {
            "BIKE",
            "CAR",
            "TRUCK",
            "CAR"
        };

        double total = 0;

        for (int i = 0; i < vehicles.length; i++) {
            double charge =
                vehicles[i].calculateCharge();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                charge
            );

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}