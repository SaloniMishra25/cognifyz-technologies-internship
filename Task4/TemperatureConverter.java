package Task4;
import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("Choose conversion direction:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the temperature to convert: ");
        double inputTemp = scanner.nextDouble();
        double convertedTemp;

        switch (choice) {
            case 1:
                // Fahrenheit to Celsius
                convertedTemp = (inputTemp - 32) * 5 / 9;
                System.out.printf("%.2f Fahrenheit = %.2f Celsius%n", inputTemp, convertedTemp);
                break;
            case 2:
                // Celsius to Fahrenheit
                convertedTemp = (inputTemp * 9 / 5) + 32;
                System.out.printf("%.2f Celsius = %.2f Fahrenheit%n", inputTemp, convertedTemp);
                break;
            default:
                System.out.println("Invalid choice. Please run the program again and select 1 or 2.");
                break;
        }

        scanner.close();
    }
}
