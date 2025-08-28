import java.util.*;
public class euler {
    // Function to compute Euler's Totient function
    public static int phi(int n) {
        int result = n; // Initialize result as n

        // Check for every number from 2 to sqrt(n)
        for (int p = 2; p * p <= n; p++) {
            // If p is a divisor of n
            if (n % p == 0) {
                // Remove all factors of p from n
                while (n % p == 0) {
                    n /= p;
                }
                // Apply phi formula: result *= (1 - 1/p)
                result -= result / p;
            }
        }

        // If n has a prime factor greater than sqrt(n)
        if (n > 1) {
            result -= result / n;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 36; // Example number
        System.out.println("Euler's Totient φ(" + n + ") = " + phi(n));
    }
}
