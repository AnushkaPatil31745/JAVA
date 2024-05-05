import java.util.Scanner;

public class unicode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(":");
        double dividend = scanner.nextDouble();

        System.out.println(":");
        double divisor = scanner.nextDouble();

        double result = dividend / divisor;

        System.out.println("The result of division " + dividend + " \u2143 " + divisor + " is: " + result);

        scanner.close();
    }
}

