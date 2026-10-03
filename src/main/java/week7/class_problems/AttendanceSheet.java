package week7.class_problems;

public class AttendanceSheet {

    private final String[] students;
    private int count;

    public AttendanceSheet(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }

        students = new String[capacity];
        count = 0;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            System.out.println(name + " already marked");
            return;
        }

        if (count >= students.length) {
            System.out.println("Attendance sheet is full");
            return;
        }

        students[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
            "Present count: " + sheet.getPresentCount()
        );

        System.out.println(
            "Ben present: " + sheet.isPresent("Ben")
        );

        System.out.println(
            "Chen present: " + sheet.isPresent("Chen")
        );
    }
}