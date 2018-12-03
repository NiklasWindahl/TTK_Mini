import java.util.Scanner;

public class Create{
  static ArrayList<UserList> user = new ArrayList<UserList>();

  UserList UsL = new UserList(userName, userPassword)
  UserList.add(UsL);

private static void createUser(Scanner scan){
  System.out.println("Enter Username: ")
  String userName = scan.next();
  System.out.println("Enter Password: ")
  String userPassword = scan.next();
  System.out.println("User: " + UsL.userName + " has been created!" \n "please choose next action");
}


  private static void createObject(Scanner scan){
      System.out.print("Name: ");
      String objectName = scan.next();
      System.out.print("Origin: ");
      String objectOrigin = scan.next();
      System.out.print("Price: ");
      double objectPrice = scan.nextDouble();
      SellableObject obj = new SellableObject(objectName, objectOrigin, objectPrice);
      objectList.add(obj);
}
