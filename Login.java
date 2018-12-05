import java.util.Scanner;
import java.util.ArrayList;
// behöver en arraylist
public class Login{

  private void run(){
    //tillfälliga classvariabler
    String Username;
    String Password;
    /* tillfälliga credentialls
    Password = "admin";
    Username = "admin";
    */
    // dölja password skrivandet;
    /*TextField password = new TextField(8);
    password.setEchoChar('*');
    */
    Scanner input1 = new Scanner(System.in);
    System.out.println("Enter Username : ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("Enter Password : ");
    String password = input2.next();

    if (username.equals(validUsers) && password.equals(validPasswords)) {

        System.out.println("Access Granted!");
    }

    else if (username.equals()) {
        System.out.println("Invalid Password!");
    } else if (password.equals()) {
        System.out.println("Invalid Username!");
    } else {
        System.out.println("Invalid Username & Password!");
    }
  }

public static void main(String[] args) {
  Scanner scan = new Scanner (System.in);
  Login lgn = new Login();

  lgn.run();
}

}
