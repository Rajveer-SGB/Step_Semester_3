package week7.assignment_problems;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {

        this.password = password;
    }

    public String getStrength() {

        if (password.length() < 6) {

            return "Weak";

        } else if (password.length() < 10) {

            return "Medium";

        } else {

            return "Strong";
        }
    }

    public static void main(String[] args) {

        PasswordChecker p1 =
                new PasswordChecker("abcd");

        PasswordChecker p2 =
                new PasswordChecker("abcdefgh");

        PasswordChecker p3 =
                new PasswordChecker("abcdefghijkl");

        System.out.println(p1.getStrength());
        System.out.println(p2.getStrength());
        System.out.println(p3.getStrength());
    }
}