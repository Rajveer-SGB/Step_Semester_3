package week9.class_problems;

import java.util.Scanner;

abstract class Travel {
    double distance;
    static final double BOOKING_FEE = 50;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusTravel extends Travel {
    BusTravel(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 2;
    }
}

class TrainTravel extends Travel {
    TrainTravel(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 1.5;
    }
}

class FlightTravel extends Travel {
    FlightTravel(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Travel travel;

            switch (type) {
                case "BUS":
                    travel = new BusTravel(distance);
                    break;
                case "TRAIN":
                    travel = new TrainTravel(distance);
                    break;
                case "FLIGHT":
                    travel = new FlightTravel(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid mode");
            }

            System.out.printf("%s: %.2f%n", type, travel.totalFare());
        }

        sc.close();
    }
}