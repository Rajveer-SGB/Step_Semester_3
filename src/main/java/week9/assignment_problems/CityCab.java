package week9.assignment_problems;

import java.util.Scanner;

interface NightService {
    default double nightFare(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double dayFare() {
        return Math.max(km * rate(), 100);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }
}

public class CityCab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab");
            }

            double fare = cab.dayFare();

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).nightFare(fare);
                } else {
                    System.out.println(type + ": night service not available");
                    continue;
                }
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}