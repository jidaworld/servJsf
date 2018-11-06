package DataLayer.DB;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IDBHandler {

    void addUser(UserEntity User) throws SQLException;

    List<UserViewModel> getUsers(String name);

}
