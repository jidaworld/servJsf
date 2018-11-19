package DataLayer.DB.Util;

import BusinessLayer.Entities.DirectMessageEntity;
import BusinessLayer.Entities.FeedMessageEntity;
import BusinessLayer.ViewModels.DirectMessageViewModel;
import BusinessLayer.ViewModels.FeedMessageViewModel;

import java.util.ArrayList;
import java.util.List;

public class DirectMessageConverter {

    public DirectMessageConverter() {

    }

    public static ArrayList<DirectMessageViewModel> convertToDMView(List<DirectMessageEntity> list){
        ArrayList<DirectMessageViewModel> returnList = new ArrayList<DirectMessageViewModel>();
        for(DirectMessageEntity m : list){
            returnList.add(new DirectMessageViewModel(
                    m.getSender().getEmail(),
                    m.getReceiver().getEmail(),
                    m.getMessage(),
                    m.getDate()));
        }
        return returnList;
    }

}
