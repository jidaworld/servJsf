package DataLayer.DB.IHandlers;

import BusinessLayer.Entities.DirectMessageEntity;
import BusinessLayer.Entities.FeedMessageEntity;
import BusinessLayer.ViewModels.DirectMessageViewModel;
import BusinessLayer.ViewModels.FeedMessageViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IMessageHandler {

    FeedMessageViewModel addFeedMessage(FeedMessageEntity messageEntity) throws SQLException;

    List<FeedMessageViewModel> getFeedFromUser(String email) throws SQLException;

    DirectMessageViewModel addDirectMessage(DirectMessageEntity messageEntity);

    List<DirectMessageViewModel> getDirectMessages(String user_1, String user_2);


}
