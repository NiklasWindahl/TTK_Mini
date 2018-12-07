import java.util.Scanner;

public class Create{

public static Users users = new Users();

Scanner scan = new Scanner(System.in);

  // static ArrayList<String> user = new ArrayList<String>();
  // static ArrayList<String> password = new ArrayList<String>();


public String nameInput(){
 String userName = scan.next();

   for (int i = 0; i < users.validUsers.size(); i++) {
     if (userName.equals(users.validUsers.get(i))) {
       userName = "-1";
     }
   }

 //users.validUsers.add(userName);
 return userName;
}

public String passInput(){
  String userPassword = scan.next();
  //users.validPasswords.add(userPassword);
  return userPassword;
}

public boolean createUser(String userName, String userPassword){
  int userArraySizeBefore = users.validUsers.size();
  users.validUsers.add(userName);
  int userArraySizeAfter = users.validUsers.size();

  int passwordArraySizeBefore = users.validPasswords.size();
  users.validPasswords.add(userPassword);
  int passwordArraySizeAfter = users.validPasswords.size();

  if (userArraySizeBefore == userArraySizeAfter || passwordArraySizeBefore == passwordArraySizeAfter){
    return false;
  }else{
    return true;
  }



}

}
