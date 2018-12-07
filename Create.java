import java.util.Scanner;
import java.util.ArrayList;

public class Create{

static Users UR = new Users();

Scanner scan = new Scanner(System.in);

  // static ArrayList<String> user = new ArrayList<String>();
  // static ArrayList<String> password = new ArrayList<String>();


public String nameInput(){
 String userName = scan.next();

   for (int i = 0; i < UR.validUsers.size(); i++) {
     if (userName.equals(UR.validUsers.get(i))) {
       userName = "-1";
     }
   }

 //UR.validUsers.add(userName);
 return userName;
}

public String passInput(){
  String userPassword = scan.next();
  //UR.validPasswords.add(userPassword);
  return userPassword;
}

public boolean createUser(String userName, String userPassword){
  int userArraySizeBefore = UR.validUsers.size();
  UR.validUsers.add(userName);
  int userArraySizeAfter = UR.validUsers.size();

  int passwordArraySizeBefore = UR.validPasswords.size();
  UR.validPasswords.add(userPassword);
  int passwordArraySizeAfter = UR.validPasswords.size();

  if (userArraySizeBefore == userArraySizeAfter || passwordArraySizeBefore == passwordArraySizeAfter){
    return false;
  }else{
    return true;
  }



}

}
