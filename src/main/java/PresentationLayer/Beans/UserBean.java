package PresentationLayer.Beans;


import BusinessLayer.Handlers.UserHandler;
import BusinessLayer.ViewModels.UserViewModel;
import DataLayer.DTO.UserDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private String UserName;
    private String Password;
    private String Email;
    private String Name;
    private String LastName;
    private UserHandler userHandler;
    private String searchName;
    private List<UserViewModel> list;

    public void addUser() {
        userHandler = new UserHandler();
        userHandler.addUser(UserName, Password, Email, Name, LastName);
    }

    public void getUsers(){
        System.out.println("hello");
        userHandler = new UserHandler();
        list = userHandler.getUsers(searchName);
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public List<UserViewModel> getList() {
        return list;
    }

    public void setList(List<UserViewModel> list) {
        this.list = list;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
