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
        UserEntity entity = new UserEntity();
        entity.setEmail(email + "4");
        entity.setPassword("kasper");
        entity.setName("kasper");
        entity.setLastName("linden");
        entity.setUserName("kasper4");

        messageEntity.setAuthor(entity);

        //messageEntity.setEmail(email);

        return handler.addFeedMessage(messageEntity);
    }

    public List<FeedMessageViewModel> GetFeedMessages(String email){

        return handler.getFeedFromUser(email);
    }

    public DirectMessageViewModel AddDirectMessage(String senderEmail, String receiverEmail, String message){
        DirectMessageEntity messageEntity = new DirectMessageEntity();

        // add stuff to messageEntity

        return handler.addDirectMessage(messageEntity);
    }

    public List<DirectMessageViewModel> GetConversation(String user_1, String user_2){
        return handler.getDirectMessages(user_1, user_2);
    }
}
