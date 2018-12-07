package DataLayer.DB.IHandlers;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IUserHandler {

    void addUser(UserEntity User);

    List<UserViewModel> getUsers(String name);

    boolean loginUser(String username, String password);

}
