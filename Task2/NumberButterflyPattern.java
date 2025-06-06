package Task2;

public class NumberButterflyPattern {
    public static void main(String[] args) {
        int n = 5; 
        printNumberButterfly(n);
    }

    public static void printNumberButterfly(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            // Left numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Right numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        // Lower half
        for (int i = n; i >= 1; i--) {
            // Left numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // Right numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
