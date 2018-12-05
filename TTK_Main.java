import java.util.Scanner;
import java.util.InputMismatchException;


public class TTK_Main {

  // Public boolean for logged in status
  public static boolean logged = false;

  // Object for calling methods in the Login class
  private static Login login = new Login();


  private void welcomeMessage(String username) {
    if (logged) {
      System.out.println('\n' + "Welcome " + username + "!");
    } else {
      System.out.println('\n' + "You are not logged in.");
    }
  }

  private void displayOptions() {
    if (!logged) {
      System.out.println('\n' + "1. Login");
    } else {
      System.out.println('\n' + "1. Logout");
    }
    System.out.println("2. Create new user");
    System.out.println("3. Quit");
  }

  private void loginOrCreateUser(Scanner scan) {

    int userOption = 0;
    boolean looping = true;

    while (looping) {

      displayOptions();

      try {
        userOption = scan.nextInt();

        String username = "-1";

        if (userOption == 1 && !logged) { // User selected "login"
          if (login.hasUsers()) {
            System.out.print('\n' + "Username: ");
            // Call the login methods...
            // Set 'username' from string returned by nameInput() method
            username = login.nameInput();
            System.out.print("Password: ");
            // Set 'password' from string returned by passInput() method
            String password = login.passInput();
            // Check if password is correct; Login.check() returns a boolean
            if (login.check(username, password)) {
              logged = true;
              welcomeMessage(username);
            } else {
              System.out.println('\n' + "Invalid username or password.");
              logged = false;
            }
          } else {
            System.out.println("No users found.");
          }
        } else if (userOption == 1 && logged) { // User selected "logout"
          System.out.println('\n' + "Logging out ...");
          logged = false;
          System.out.println("You are logged out.");
          username = "-1";
        } else if (userOption == 2) { // User selected "create new user"
          // Create.create();
          System.out.println('\n' + "[call methods to create user]");
        } else if (userOption == 3) { // User selected "quit"
          System.out.println("Goodbye.");
          looping = false;
        } else {
          System.out.println("Please enter a valid option." + '\n');
        }
      }
      catch (InputMismatchException e) {
        System.out.println("Input mismatch." + '\n');
        scan.next();
      }
    } // while closure
  }

  // --------------------------------------------------------------------------

  public static void main(String[] args) {

    TTK_Main ttk_main = new TTK_Main();
    Scanner scan = new Scanner(System.in);

    // Temporary solution: adds a number of users
    login.createUsers();

    // Run the menu
    ttk_main.loginOrCreateUser(scan);

    scan.close();

  }

}
