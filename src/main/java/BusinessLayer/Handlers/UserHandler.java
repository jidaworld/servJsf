package BusinessLayer.Handlers;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;
import DataLayer.DB.DBHandler;
import org.mindrot.jbcrypt.BCrypt;
import java.util.List;

public class UserHandler {

    private DBHandler dbHandler = null;

    public UserHandler(){
        dbHandler = new DBHandler();
    }

    public void addUser(String UserName, String Password, String Email, String Name, String LastName) {

        UserEntity user = new UserEntity();
        BCrypt crypto = new BCrypt();
        String hash = BCrypt.hashpw(Password, BCrypt.gensalt());
        user.setPassword(hash);
        user.setUserName(UserName);
        user.setPassword(hash);
        user.setEmail(Email);
        user.setName(Name);
        user.setLastName(LastName);

        dbHandler.addUser(user);
    }

    public List<UserViewModel> getUsers(String name){
        return dbHandler.getUsers(name);
    }


}
