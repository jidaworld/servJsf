package BusinessLayer.Handlers;

import BusinessLayer.Entities.DirectMessageEntity;
import BusinessLayer.Entities.FeedMessageEntity;
import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.DirectMessageViewModel;
import BusinessLayer.ViewModels.FeedMessageViewModel;
import DataLayer.DB.Handlers.MessageDBHandler;

import java.util.List;

public class MessageHandler {

    private MessageDBHandler handler = null;

    public MessageHandler() {
        this.handler = new MessageDBHandler();
    }

    public FeedMessageViewModel AddFeedMessage(String email, String message){
        FeedMessageEntity messageEntity = new FeedMessageEntity();
        messageEntity.setMessage(message);

        return handler.addFeedMessage(messageEntity, email);
    }

    public List<FeedMessageViewModel> GetFeedMessages(String email){

        return handler.getFeedFromUser(email);
    }

    public DirectMessageViewModel AddDirectMessage(String senderEmail, String receiverEmail, String message){
        DirectMessageEntity messageEntity = new DirectMessageEntity();
        messageEntity.setMessage(message);

        return handler.addDirectMessage(messageEntity, senderEmail, receiverEmail);
    }

    public List<DirectMessageViewModel> GetDirectMessage(String user_1, String user_2){
        return handler.getDirectMessages(user_1, user_2);
    }
}
