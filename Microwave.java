// Import scanner class to get input.
import java.util.Scanner;

/** .
* Says how long it takes to cook a certain item by quantity.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-02-24
*/

// Creating class
public final class Microwave {
    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) {

        // Declare constants
        final double PIZZA_TIME = 0.45;
        final double SUB_TIME = 1;
        final double SOUP_TIME = 1.45;
        final String foodString;

        // Welcome and get user input
        System.out.print("This program is a microwave and");
        System.out.print(" calculates how long it takes for a");
        System.out.print("certain food by quantity. ");
        System.out.println("Select a food to reheat ");
        System.out.println("('sub', 'pizza', or 'soup'): ");

        // Using scanner to get user input
        final Scanner scanner = new Scanner(System.in);
        foodString = scanner.nextLine();

        // Check if food input is valid
        if (foodString.equals("sub") || foodString.equals("pizza")
            || foodString .equals("soup")) {

            // Get quantity from user
            System.out.println("Select a quantity ('1', '2', or '3'): ");

            // try converting quantity to integer
            try {

                // Try casting input to integer and assigning to variable
                int quantity = Integer.parseInt(scanner.nextLine());

                // Check if quantity is out of range
                if (quantity < 1 || quantity > 3) {

                    // If out of range tell user
                    System.out.println(quantity + " is not a valid quantity.");

                // Otherwise calculate cooking time
                } else {
                    // Determine base cooking time
                    double baseTime;

                    // Check food input and assign base cooking time
                    if (foodString.equals("pizza")) {
                        baseTime = PIZZA_TIME;
                    } else if (foodString.equals("sub")) {
                        baseTime = SUB_TIME;
                    } else {
                        baseTime = SOUP_TIME;
                    }

                    // Calculate min and sec for cooking time
                    double totalTime = baseTime * quantity;
                    int minutes = (int) totalTime;
                    int seconds = (int) ((totalTime - minutes) * 60);
                    
                    // Print result to user
                    System.out.println(quantity + " " + foodString + "(s), will take "
                        + minutes + "m " + seconds + "s.");
                }

                // Catch invalid inputs and tell user
            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid input. "
                        + error.getMessage());
            }

            // Catch any food inputs that are not valid
        } else {
            System.out.println(foodString + " is not a valid food input.");
        }

        // Close scanner
        scanner.close();
    }
}
