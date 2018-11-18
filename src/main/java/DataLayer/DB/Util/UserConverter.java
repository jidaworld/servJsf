package DataLayer.DB.Util;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public UserConverter(){

    }

    public static ArrayList<UserViewModel> convertToUserView(List<UserEntity> list){
        ArrayList<UserViewModel> returnList = new ArrayList<UserViewModel>();
        for (UserEntity u : list) {
            returnList.add(new UserViewModel(
                    u.getUserName(),
                    u.getEmail(),
                    u.getName(),
                    u.getLastName())
            );
        }
        return returnList;
    }

}
