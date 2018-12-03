import java.util.ArrayList;

public class Users{
  private ArrayList<String> validUsers = new ArrayList<String>();
  private ArrayList<String> validPasswords = new ArrayList<String>();

  public void UserList(){
      validUsers = new ArrayList();
      validPasswords = new ArrayList();

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

}
