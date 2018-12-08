import java.util.Scanner;
import java.util.InputMismatchException;

/* TODO
* Bryt ut metoder ur loginOrCreateUser() och döp om den till userMenu()
* */

public class TTK_Main {

  // Boolean for the logged in status
  private static boolean logged = false;
  // String for the currently logged username; "-1" means no username
  private static String username = "-1";
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

  private void login() {
    if (login.hasUsers()) {

      // Set 'username' from string returned by nameInput()
      System.out.print('\n' + "Username: ");
      username = login.nameInput();

      // Set 'password' from string returned by passInput()
      System.out.print("Password: ");
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

  private void logout() {
    System.out.println('\n' + "Logging out ...");
    logged = false;
    System.out.println("You are logged out.");
    username = "-1";
  }

  private void createUser() {
    String newPassword;
    String repeatedPassword;
    boolean setPasswordSuccess = false;
    String newUsername = "-1";

    while (newUsername.equals("-1")) {
      System.out.print('\n' + "Enter a new username: ");
      newUsername = create.nameInput(); // method returns "-1" if user exists
      if (newUsername.equals("-1")) {
        System.out.print('\n' + "Username taken, choose another.");
      }
    }

    do {
      System.out.print('\n' + "Enter a password for user " + newUsername + ": ");
      newPassword = create.passInput();
      System.out.print("Repeat the password: ");
      repeatedPassword = create.passInput();

      if (newPassword.equals(repeatedPassword)) {
        setPasswordSuccess = true;
      } else {
        System.out.println('\n' + "Mismatch, try again.");
        setPasswordSuccess = false;
      }
    } while (!setPasswordSuccess);

    // We now have everything we need to create a new user

    System.out.print('\n' + "Creating user " + newUsername + " ... ");
    boolean userWasCreated = false;
    // If createUser() returns true, the user should have been added
    userWasCreated = create.createUser(newUsername, newPassword);
    if (userWasCreated) {
      System.out.println("DONE.");
    } else {
      System.out.println("FAILED.");
    }
  }

  private void userMenu(Scanner scan) {

    int userOption = 0;
    boolean looping = true;

    while (looping) {

      displayOptions();

      System.out.println("Number of users in the ArrayList: " + login.users.validUsers.size() + '\n');

      try {
        userOption = scan.nextInt();

        if (userOption == 1 && !logged) {
          login();
        } else if (userOption == 1 && logged) {
          logout();
        } else if (userOption == 2) {
          createUser();
        } else if (userOption == 3) {
          System.out.println("Goodbye.");
          looping = false;
        } else {
          System.out.println("Please enter a valid option.");
        }
      }
      catch (InputMismatchException e) {
        System.out.println("Input mismatch.");
        scan.next();
      }
    } // while closure
  }

  // --------------------------------------------------------------------------

  public static void main(String[] args) {

    TTK_Main ttk_main = new TTK_Main();
    Scanner scan = new Scanner(System.in);

    // Temporary solution: adds a number of users
    // login.createUsers();

    // Run the menu
    ttk_main.userMenu(scan);

    scan.close();

  }

}
