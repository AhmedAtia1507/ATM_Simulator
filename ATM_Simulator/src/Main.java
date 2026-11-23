import java.util.Scanner;

public class Main {
    public static void main ( String[] args ) {
        Scanner inputScanner = new Scanner( System.in );
        // User has 3 available attempts. If all attempts failed, the program will block the user
        int availableLoginAttempts = 3;
        int correctPin = 1234;
        int inputPin = 0;

        while ( availableLoginAttempts > 0 ) {
            System.out.print("Please enter the 4-digit PIN: ");
            inputPin = inputScanner.nextInt();

            // If the user input PIN is not a 4-digit number or not matching the correct PIN, an error message will be
            // printed and the user will be prompted to try again
            // Else, the system will output "Logged in successfully. Welcome User!!"
            if ( ( inputPin < 0 ) || ( inputPin > 9999 ) ) {
                System.out.println("Invalid input PIN: input PIN must be 4-digits positive value");
            }
            else if ( ( inputPin != correctPin ) ) {
                System.out.println("Incorrect input PIN !!!");
            }
            else {
                System.out.println("Logged in successfully. Welcome User!!");
                break;
            }

            availableLoginAttempts--;

            if ( availableLoginAttempts > 0 ) {
                System.out.println("Available login attempts: " + availableLoginAttempts + ". Please try again");
            }
        }

        // If the user used all his attempts and didn't enter the correct PIN, the System will block him
        // and exit the program
        if ( availableLoginAttempts == 0 ) {
            System.out.println("You have used all your login attempts. Your Account has been blocked!!!");
            return;
        }
    }
}