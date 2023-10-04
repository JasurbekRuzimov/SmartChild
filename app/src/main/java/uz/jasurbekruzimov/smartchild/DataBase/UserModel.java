package uz.jasurbekruzimov.smartchild.DataBase;

public class UserModel {
    String email;
    String password;
    String phoneNumber;

    public UserModel(String email, String password, String phoneNumber) {

        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
