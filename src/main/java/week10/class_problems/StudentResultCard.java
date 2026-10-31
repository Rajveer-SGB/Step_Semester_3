package week10.class_problems;

import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }
        return (double) sum / marks.length;
    }

    public char getGrade() {
        double avg = calculateAverage();
        if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printCard() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), calculateAverage(), getGrade());
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = sc.nextInt();

        Student[] students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name and 3 marks for student " + (i + 1) + ": ");
            String name = sc.next();
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextInt();
            }
            students[i] = new Student(name, marks);
        }

        System.out.println();
        for (int i = 0; i < count; i++) {
            students[i].printCard();
        }
        sc.close();
    }
}