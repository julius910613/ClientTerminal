package model;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 06/03/14
 * Time: 09:00
 * To change this template use Document | Settings | Document Templates.
 */
public class User {


    private String userEmailAddress;
    private String userName;





    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User [email =" + userEmailAddress + ", userName=" + userName + "]";
    }
}
