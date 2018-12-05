import java.util.Scanner;
import java.util.ArrayList;
// behöver en arraylist



public class Login{

public Users users = new Users();
public String nameInput() {
  Scanner input1 = new Scanner (System.in);
  String userName = input1.next();
  return userName;
}


public String passInput() {
  Scanner input1 = new Scanner (System.in);
  String userPass = input1.next();
  return userPass;
}
public boolean check(String userName, String Password) {
  for(int i = 0; i < users.length; i++){

if(userName == users.validUsers.get(i))
if(userPass == users.validPasswords.get(i)){
return true;
} else { return false;
      }
    }
  }
}
/*
  private void run(){
    Scanner input1 = new Scanner(System.in);
    String username = input1.next();

    Scanner input2 = new Scanner(System.in);
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
    */
