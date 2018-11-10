package BusinessLayer.ViewModels;

public class UserViewModel {

    private String userName;
    private String email;
    private String name;
    private String lastName;

    public UserViewModel(String userName, String email, String name, String lastName){
        this.userName = userName;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "UserViewModel{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
