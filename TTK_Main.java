import java.util.Scanner;
import java.util.InputMismatchException;

public class TTK_Main {

  // Public boolean for logged in status
  public static boolean logged = false;
  // Private boolean for menu loops
  private static boolean looping = true;
  // Private string for currently logged in username
  private static String username = "-1";


  private void welcomeMessage() {
    if (!username.equals("-1")) {
      System.out.println("Welcome " + username + "!" + '\n');
    } else {
      System.out.println("You are not logged in." + '\n');
    }

  }

  private void displayOptions() {
    if (!logged) {
      System.out.println("1. Login");
    }

    System.out.println("2. Create new user");

    if (logged) {
      System.out.println("3. Logout");
    }
    else {
      System.out.println("3. Quit");
    }
  }

  private boolean loginOrCreateUser(Scanner scan) {

    int userOption = 0;
    looping = true;

    while (looping) {

      displayOptions();

      try {
        userOption = scan.nextInt();
        if (userOption == 1) {
          System.out.println('\n' + "[call method to login user]");
          // System.out.print('\n' + "Username: ");
          // Call the login method:
          // 1. Sends 'username' as parameter to be checked;
          // 2. Sets 'username' from string returned by login method
          // username = Login.login(username);
          // Add if-statement here? if (username != "-1") { logged = true } ?
          logged = true; // Set user as logged in
          System.out.println("You are logged in." + '\n');
        } else if (userOption == 2) {
          // Create.create();
          System.out.println('\n' + "[call method to create user]");
        } else if (userOption == 3 && logged) { // User selected "logout"
          System.out.println("Loggin out ...");
          logged = false;
          System.out.println("You are logged out." + '\n');
        } else if (userOption == 3 && !logged) { // User selected "quit"
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
    return looping;
  }

  // --------------------------------------------------------------------------

  public static void main(String[] args) {

    TTK_Main ttk_main = new TTK_Main();
    Scanner scan = new Scanner(System.in);

    while (looping) {
      ttk_main.welcomeMessage();
      looping = ttk_main.loginOrCreateUser(scan);
    }

    scan.close();

  } // main closure

}
