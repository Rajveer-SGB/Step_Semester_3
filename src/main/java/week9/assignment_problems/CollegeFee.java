package week9.assignment_problems;

import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000;

    default double transportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class CollegeStudent {
    String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double tuitionFee();

    double totalFee() {
        double total = tuitionFee();

        if (this instanceof BusUser) {
            total += ((BusUser) this).transportFee();
        }

        return total;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000;
    }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double tuitionFee() {
        return 20000;
    }
}

public class CollegeFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            CollegeStudent student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }

            double fee = student.totalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}