import java.util.Scanner;
import java.util.ArrayList;

public class Create{



Scanner scan = new Scanner(System.in);

  static ArrayList<String> user = new ArrayList<String>();
  static ArrayList<String> password = new ArrayList<String>();

//  UserList UsL = new UserList(userName, userPassword);

private void createUser(){

 System.out.println("Enter Username: ");
 String userName = scan.next();
 user.add(userName);

 System.out.println("Enter Password: ");
 String userPassword = scan.next();
 password.add(userPassword);

 System.out.println("User: " + userName + " has been created!       please choose next action");

}

/*
public void createUser(Scanner scan){
  System.out.println("Enter Username: ");
  String userName = scan.next();
  System.out.println("Enter Password: ");
  String userPassword = scan.next();
  System.out.println("User: " + this.userName + " has been created!       please choose next action");
  Users.validUsers.add(this.userName);
  Users.validPasswords.add(this.userPassword);
} */

  public static void main(String[] args) {
    Create CR = new Create();
    System.out.println(user.size());
    CR.createUser();
    System.out.println(user.size());



  // Scanner scan = new Scanner(System.in);
  // Create CR = new Create();
  // CR.createUser();
}

}
