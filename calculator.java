import java.util.Scanner;

public class calculator {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Error!");
        }
    }

    public static double square(double num) {
        return num * num;
    }

    public static double cube(double num) {
        return num * num * num;
    }

    public static double squareRoot(double num) {
        if (num >= 0) {
            return Math.sqrt(num);
        } else {
            throw new ArithmeticException("Error!!");
        }
    }

    public static double cubeRoot(double num) {
        return Math.cbrt(num);
    }

    public static void main(String[] args) {
    char choice;
    Scanner scanner = new Scanner(System.in);
     double result = 0;
    do{
    
        
        double num1, num2;
        char operator;

        System.out.print(" ");
        num1 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /, s, c,t,b): ");
        operator = scanner.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.print(" ");
                num2 = scanner.nextDouble();
                result = add(num1, num2);
                break;
            case '-':
                System.out.print(" ");
                num2 = scanner.nextDouble();
                result = subtract(num1, num2);
                break;
            case '*':
                System.out.print("");
                num2 = scanner.nextDouble();
                result = multiply(num1, num2);
                break;
            case '/':
                System.out.print(" ");
                num2 = scanner.nextDouble();
                try {
                    result = divide(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            case 's':
                result = square(num1);
                break;
            case 'c':
                result = cube(num1);
                break;
            case 't':
                try {
                    result = squareRoot(num1);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            case 'b':
                result = cubeRoot(num1);
                break;
        }

        System.out.println(" " + result);
         System.out.println("Do you want to perform more operation?'y/n'");
          choice = scanner.next().charAt(0);
         
        
} while(choice == 'y');
        scanner.close();
    }
}

