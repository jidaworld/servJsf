package DataLayer.DB.Util;

import BusinessLayer.Entities.FeedMessageEntity;
import BusinessLayer.ViewModels.FeedMessageViewModel;

import java.util.ArrayList;
import java.util.List;

public class FeedMessageConverter {

    public FeedMessageConverter() {

    }

    public static ArrayList<FeedMessageViewModel> convertToFMView(List<FeedMessageEntity> list){
        ArrayList<FeedMessageViewModel> returnList = new ArrayList<FeedMessageViewModel>();
        for(FeedMessageEntity m : list){
            returnList.add(new FeedMessageViewModel(
                    m.getMessage(),
                    m.getDate(),
                    m.getAuthor().getName(),
                    m.getAuthor().getLastName()));
        }
        return returnList;
    }
}
