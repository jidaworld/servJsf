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
        for(int i = 0; i<list.size(); i++){
            returnList.add(new UserViewModel(
                    list.get(i).getUserName(),
                    list.get(i).getEmail(),
                    list.get(i).getName(),
                    list.get(i).getLastName())
            );
        }
        return returnList;
    }

}
