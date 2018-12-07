import java.util.Scanner;
import java.util.InputMismatchException;


public class TTK_Main {

  // Public boolean for logged in status
  public static boolean logged = false;

  // Objects for calling methods in the Login + Create classes
  private static Login login = new Login();
  private static Create create = new Create();


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
      boolean passwordSuccess = false;
      String newPassword = "-1";
      String repeatedPassword = "-2";

      try {
        userOption = scan.nextInt();

        String username = "-0";

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
        }

        else if (userOption == 1 && logged) { // User selected "logout"
          System.out.println('\n' + "Logging out ...");
          logged = false;
          System.out.println("You are logged out.");
          username = "-1";
        }

        else if (userOption == 2) { // User selected "create new user"

          String newUsername = "-1";

          while (newUsername.equals("-1")) {
            System.out.print('\n' + "Enter a new username: ");
            newUsername = create.nameInput();
            if (newUsername.equals("-1")) {
              System.out.print('\n' + "Username taken, choose another.");
            }
          }

          do {
            System.out.print('\n' + "Enter a password for user " + newUsername + ": ");
            newPassword = create.passInput();
            System.out.print('\n' + "Repeat the password: ");
            repeatedPassword = create.passInput();

            if (newPassword.equals(repeatedPassword)) {
              passwordSuccess = true;
            } else {
              System.out.println('\n' + "Mismatch, try again.");
              passwordSuccess = false;
            }
          } while (!passwordSuccess);

          // We now have everything we need to create a new user

          System.out.print('\n' + "Creating user " + newUsername + " ... ");
          boolean userWasCreated = false;
          // If createUser() returns true, we will know that it worked
          userWasCreated = create.createUser(newUsername, newPassword);
          if (userWasCreated) {
            System.out.println("DONE.");
          } else {
            System.out.println("FAILED.");
          }

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
