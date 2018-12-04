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
  System.out.println("Welcome!!!" + '\n');
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
  boolean looping = true;

  while (looping) {

   displayOptions();

   try {
    userOption = scan.nextInt();
    if (userOption == 1) {
     // Login.login();
     System.out.println('\n' + "[call method to login user]");
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

  ttk_main.welcomeMessage();

  while (looping) {
   looping = ttk_main.loginOrCreateUser(scan);
  }

  scan.close();

 } // main closure

}
