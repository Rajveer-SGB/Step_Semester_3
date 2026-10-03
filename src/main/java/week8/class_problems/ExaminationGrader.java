package week8.class_problems;

abstract class Question {
    protected double points;

    Question(double points) {
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    private String correctAnswer;
    private String studentAnswer;

    MCQ(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        super(points);
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
    }

    @Override
    double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TrueFalse extends Question {
    private String correctAnswer;
    private String studentAnswer;

    TrueFalse(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        super(points);
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
    }

    @Override
    double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    private String correctAnswer;
    private String studentAnswer;

    Essay(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {
        super(points);
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
    }

    @Override
    double grade() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matches = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {

        Question[] questions = {
            new MCQ("Paris", "Paris", 10),
            new TrueFalse("False", "True", 5),
            new Essay(
                "Inheritance, Polymorphism, Encapsulation",
                "Polymorphism is one.",
                20
            ),
            new Essay(
                "Abstraction, Composition",
                "I talked about abstraction.",
                15
            )
        };

        String[] types = {
            "MCQ",
            "TF",
            "ESSAY",
            "ESSAY"
        };

        double total = 0;

        for (int i = 0; i < questions.length; i++) {
            double score = questions[i].grade();

            System.out.printf(
                "%s: %.2f%n",
                types[i],
                score
            );

            total += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            total
        );
    }
}