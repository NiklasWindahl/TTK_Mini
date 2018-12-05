import java.util.Scanner;
import java.util.InputMismatchException;








public class TTK_Main {

  // Public boolean for logged in status
  public static boolean logged = false;
  // Private string for currently logged in username
  private static String username = "-1";

  public Users users = new Users();

  private void welcomeMessage() {
    if (logged) {
      System.out.println("Welcome " + username + "!" + '\n');
    } else {
      System.out.println("You are not logged in." + '\n');
    }
  }

  private void displayOptions() {
    if (!logged) {
      System.out.println("1. Login");
    } else {
      System.out.println("1. Logout");
    }
    System.out.println("2. Create new user");
    System.out.println("3. Quit");
  }

  private void loginOrCreateUser(Scanner scan) {

    int userOption = 0;
    boolean looping = true;

    String username = "-1";
    String password = "-1";

    while (looping) {

      displayOptions();

      // users.createUsers();
      // System.out.println(users.validUsers.get(1));

      try {
        userOption = scan.nextInt();

        if (userOption == 1 && !logged) { // User selected "login"
          System.out.print('\n' + "Username: ");
          // Call the login methods...
          // Set 'username' from string returned by nameInput() method
          username = Login.nameInput();
          System.out.print("Password: ");
          // Set 'password' from string returned by passInput() method
          password = Login.passInput();
          // Check if password is correct; Login.check() returns a boolean
          if (Login.check(username, password)) {
            logged = true;
            welcomeMessage();
          }
        } else if (userOption == 1 && logged) { // User selected "logout"
          System.out.println("Logging out ...");
          logged = false;
          System.out.println("You are logged out." + '\n');
          // username = "-1";
        } else if (userOption == 2) { // User selected "create new user"
          // Create.create();
          System.out.println('\n' + "[call methods to create user]" + '\n');
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


    ttk_main.loginOrCreateUser(scan);

    scan.close();

    // System.out.println(users.validPasswords.get(1));

  } // main closure

}
