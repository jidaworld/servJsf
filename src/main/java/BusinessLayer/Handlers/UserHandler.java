package BusinessLayer.Handlers;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;
import DataLayer.DB.Handlers.UserDBHandler;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

public class UserHandler {

    private UserDBHandler userDbHandler;

    public UserHandler(){
        userDbHandler = new UserDBHandler();
    }

    public void addUser(String UserName, String Password, String Email, String Name, String LastName) {

        UserEntity user = new UserEntity();
        String hash = BCrypt.hashpw(Password, BCrypt.gensalt());
        user.setPassword(hash);
        user.setUserName(UserName);
        user.setPassword(hash);
        user.setEmail(Email);
        user.setName(Name);
        user.setLastName(LastName);

        userDbHandler.addUser(user);
    }

    public List<UserViewModel> getUsers(String name){
        return userDbHandler.getUsers(name);
    }

    public boolean Login(String username, String password) {
        return userDbHandler.loginUser(username, password);
    }


}
