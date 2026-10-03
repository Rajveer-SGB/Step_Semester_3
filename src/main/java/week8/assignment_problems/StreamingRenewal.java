package week8.assignment_problems;

import java.time.LocalDate;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, String startDate) {
        this.name = name;
        this.startDate =
            LocalDate.parse(startDate);
    }

    abstract LocalDate getRenewalDate();
}

class BasicPlan extends Plan {
    BasicPlan(String name, String startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, String startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, String startDate) {
        super(name, startDate);
    }

    @Override
    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {

        Plan[] plans = {
            new BasicPlan(
                "Asha",
                "2024-01-15"
            ),
            new StandardPlan(
                "Ravi",
                "2024-02-01"
            ),
            new PremiumPlan(
                "Neha",
                "2024-03-10"
            ),
            new BasicPlan(
                "Kiran",
                "2024-12-20"
            )
        };

        for (Plan plan : plans) {
            System.out.println(
                plan.name + ": " +
                plan.getRenewalDate()
            );
        }
    }
}