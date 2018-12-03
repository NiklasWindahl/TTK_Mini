import java.util.Scanner;
import java.util.ArrayList;

public class Create{
  Scanner scan = new Scanner();
  static ArrayList<String> user = new ArrayList<String>();
  UserList UsL = new UserList(userName, userPassword);


private static void createUser(Scanner scan){
  System.out.println("Enter Username: ");
  String userName = scan.next();
  System.out.println("Enter Password: ");
  String userPassword = scan.next();
  System.out.println("User: " + UsL.userName + " has been created!       please choose next action");
  Users.UserList.add(UsL);
  }

/*
public static void main(String[] args) {
  Create CR = new Create();
  CR.createUser();
} */

}
