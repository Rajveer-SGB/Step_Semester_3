package week7.class_problems;

public class Scorecard {

    private final boolean[] answers;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            throw new IllegalArgumentException(
                "Question count cannot be negative"
            );
        }

        answers = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount >= answers.length) {
            System.out.println("All answers already recorded");
            return;
        }

        answers[answerCount] = correct;
        answerCount++;
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}