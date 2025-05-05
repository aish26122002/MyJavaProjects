import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        runCalculator(scanner);
        System.out.println("Calculator exited.");
        scanner.close();
    }

    public static void runCalculator(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.print("Enter operation number, or 'exit' , 'back': ");
            String opChoice = scanner.nextLine().trim();

            if (opChoice.equalsIgnoreCase("exit")) {
                break;
            } else if (opChoice.equalsIgnoreCase("back")) {
                continue;
            }

            switch (opChoice) {
                case "1":
                    System.out.println("add numbers(int).");
                    handleAddition(scanner);
                    break;
                case "2":
                    System.out.println("subtract numbers(int).");
                    handleSubtraction(scanner);
                    break;
                case "3":
                    System.out.println("multiply numbers(double).");
                    handleMultiplication(scanner);
                    break;
                case "4":
                    System.out.println("divide numbers(double).");
                    handleDivision(scanner);
                    break;
                default:
                    System.out.println("Invalid operation. Please select a valid option.");
            }
        }
    }

    private static void handleAddition(Scanner scanner) {
        System.out.print("Enter n numbers to add: ");
        int n = getIntInput(scanner);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += getIntInput(scanner);
        }
        System.out.println("The result of addition is: " + sum);
    }

    private static void handleSubtraction(Scanner scanner) {
        System.out.print("Enter first number (int): ");
        int num1 = getIntInput(scanner);
        System.out.print("Enter second number (int): ");
        int num2 = getIntInput(scanner);
        int result = num1 - num2;
        System.out.println("The result of subtraction is: " + result);
    }

    private static void handleMultiplication(Scanner scanner) {
        System.out.print("Enter how many numbers to multiply: ");
        int n = getIntInput(scanner);
        double product = 1.0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            product *= getDoubleInput(scanner);
        }
        System.out.println("The result of multiplication is: " + product);
    }

    private static void handleDivision(Scanner scanner) {
        System.out.print("Enter first number (double): ");
        double num1 = getDoubleInput(scanner);
        System.out.print("Enter second number (double): ");
        double num2 = getDoubleInput(scanner);

        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return;
        }

        double result = num1 / num2;
        System.out.println("The result of division is: " + result);
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid decimal number.");
            }
        }
    }

}
