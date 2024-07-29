import java.util.Scanner;

public class ATMMenu {
    private User currentUser;

    public ATMMenu(User user) {
        this.currentUser = user;
    }

    public void displayMenu(Scanner scanner) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Select an option: ");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Set Daily Withdrawal Limit");
            System.out.println("6. Quit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    currentUser.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    currentUser.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    currentUser.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient User ID: ");
                    String recipientId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    User recipient = ATM.findUserById(recipientId);
                    if (recipient != null) {
                        currentUser.transfer(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient not found.");
                    }
                    break;
                    case 5:
                    System.out.print("Enter new daily withdrawal limit: ");
                    double newLimit = scanner.nextDouble();
                    scanner.nextLine();   
                    currentUser.setDailyWithdrawalLimit(newLimit);
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you for choosing our ATM. Your transaction is complete. Have a wonderful day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}