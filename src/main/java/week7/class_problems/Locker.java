package week7.class_problems;

public class Locker {

    private String combination;
    private final int lockerNumber;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public void changeCode(String oldCode, String newCode) {
        if (!combination.equals(oldCode)) {
            System.out.println("Code change rejected");
            return;
        }

        combination = newCode;
        System.out.println("Code changed successfully");
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        locker.changeCode("1234", "5678");
        locker.changeCode("0000", "9999");
    }
}