import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        
        users.add(new User("user1", "1234"));
        users.add(new User("user2", "5678"));

        System.out.println("Welcome to the ATM!");

        
        while (currentUser == null) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
            currentUser = authenticateUser(userId, pin);
            if (currentUser == null) {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        ATMMenu menu = new ATMMenu(currentUser);
        menu.displayMenu(scanner);
    }

    private static User authenticateUser(String userId, String pin) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.checkPin(pin)) {
                return user;
            }
        }
        return null;
    }

    public static User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}