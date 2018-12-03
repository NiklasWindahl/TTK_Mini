import java.util.Scanner;
// behöver en arraylist
public class Login{

  private void run(){
    String Username;
    String Password;

    Password = "admin";
    Username = "admin";

    Scanner input1 = new Scanner(System.in);
    System.out.println("Enter Username : ");
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
    System.out.println("Enter Password : ");
    String password = input2.next();

    if (username.equals(Username) && password.equals(Password)) {

        System.out.println("Access Granted!");
    }

    else if (username.equals(Username)) {
        System.out.println("Invalid Password!");
    } else if (password.equals(Password)) {
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
