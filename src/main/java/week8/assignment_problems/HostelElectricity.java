package week8.assignment_problems;

abstract class Room {
    protected int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    ACRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 10 + 200;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {

        Room[] rooms = {
            new SingleRoom(120),
            new SharedRoom(150, 3),
            new ACRoom(100)
        };

        String[] types = {
            "SINGLE",
            "SHARED",
            "AC"
        };

        double total = 0;

        for (int i = 0; i < rooms.length; i++) {
            double bill = rooms[i].calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                bill
            );

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}