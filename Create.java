import java.util.Scanner;

public class Create{
  Scanner scan = new Scanner();
  static ArrayList<UserList> user = new ArrayList<UserList>();
  UserList UsL = new UserList(userName, userPassword);


private static void createUser(Scanner scan){
  System.out.println("Enter Username: ");
  String userName = scan.next();
  System.out.println("Enter Password: ");
  String userPassword = scan.next();
  System.out.println("User: " + UsL.userName + " has been created!" \n "please choose next action");
  UserList.add(UsL);
  }



}
