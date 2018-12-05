import java.util.ArrayList;

public class Users{
  public ArrayList<String> validUsers = new ArrayList<String>();
  public ArrayList<String> validPasswords = new ArrayList<String>();


  public void createUsers() {
    validUsers.add("user1");
    validUsers.add("user2");
    validUsers.add("user3");
    validUsers.add("user4");
    validUsers.add("user5");

    validPasswords.add("password1");
    validPasswords.add("password2");
    validPasswords.add("password3");
    validPasswords.add("password4");
    validPasswords.add("password5");
  }

/*
  public void Users(){
      validUsers = new ArrayList();
      validPasswords = new ArrayList();
  }
*/

}
