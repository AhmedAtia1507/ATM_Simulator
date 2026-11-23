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

        double userCurrentBalance = 2500.75;
        double userInputAmount = 0.0;
        int userMenuChoice = 0;
        int validWithdrawals = 0;
        int validDeposits = 0;

        do {
            System.out.println("========= ATM =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("=======================");

            // If current balance is 0.0, display a warning message stating that the account is empty
            if ( userCurrentBalance == 0.0 ) {
                System.out.println( "Warning!! Your account is empty!!" );
            }

            System.out.print("Please enter your choice: ");
            userMenuChoice = inputScanner.nextInt();

            // Break from the while loop whenever the user chooses the exit menu choice
            if ( userMenuChoice == 5 ) {
                System.out.println("Thank you for using our ATM");
                break;
            }

            switch ( userMenuChoice ) {
                case 1 -> { // Display current Balance
                    System.out.println( "Your current balance is $" + userCurrentBalance );
                }
                case 2 -> { // Deposit
                    System.out.print("Please enter the amount to deposit: ");
                    userInputAmount = inputScanner.nextDouble();

                    // Input amount to be deposited must be positive value
                    if ( userInputAmount > 0.0 ) {
                        userCurrentBalance += userInputAmount;
                        validDeposits++;
                        System.out.println("Amount added successfully!! New balance is $" + userCurrentBalance);
                    }
                    else {
                        System.out.println( "Invalid Amount!!" );
                    }
                }
                case 3 -> { // Withdrawal
                    System.out.print("Please enter the amount to withdraw: ");
                    userInputAmount = inputScanner.nextDouble();

                    // If user input was 0, we simulate canceled transaction
                    // Withdrawal Amount must be positive and do not exceed the current balance
                    if ( userInputAmount == 0 ) {
                        System.out.println( "Transaction Canceled" );
                    }
                    else if ( ( userInputAmount > 0.0 ) && ( userInputAmount <= userCurrentBalance ) ) {
                        userCurrentBalance -= userInputAmount;
                        validWithdrawals++;
                        System.out.println("Amount withdrawn successfully!! New balance is $" + userCurrentBalance);
                    }
                    else {
                        System.out.println( "Insufficient Amount!!" );
                    }
                }
                case 4 -> {
                    // current balance >= 5000 ---> VIP
                    // 1000 <= current balance < 5000 ---> Regular
                    // current balance < 1000 --> low balance
                    if ( userCurrentBalance >= 5000 ) {
                        System.out.println( "You are a VIP customer!!" );
                    }
                    else if ( userCurrentBalance >= 1000 ) {
                        System.out.println( "You are a Regular customer!!" );
                    }
                    else {
                        System.out.println( "You have a low balance" );
                    }
                }
                default -> {
                    System.out.println( "Invalid Option!!" );
                }
            }
        } while ( true );

        // Display the number of valid transactions along the program
        System.out.println("Number of successful deposits: " + validDeposits);
        System.out.println("Number of successful withdrawals: " + validWithdrawals);
    }
}