package DataLayer.DB.Handlers;

import BusinessLayer.Entities.DirectMessageEntity;
import BusinessLayer.Entities.FeedMessageEntity;
import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.DirectMessageViewModel;
import BusinessLayer.ViewModels.FeedMessageViewModel;
import DataLayer.DB.IHandlers.IMessageHandler;
import DataLayer.DB.Util.DirectMessageConverter;
import DataLayer.DB.Util.FeedMessageConverter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MessageDBHandler implements IMessageHandler {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");

    public MessageDBHandler() {
    }

    public FeedMessageViewModel addFeedMessage(FeedMessageEntity messageEntity, String email) {

        UserEntity userEntity;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
            query.setParameter(1, email);
            userEntity = query.getSingleResult();
            messageEntity.setAuthor(userEntity);
            em.persist(messageEntity);
            em.flush();
            FeedMessageViewModel m = new FeedMessageViewModel(
                    messageEntity.getMessage(),
                    messageEntity.getDate(),
                    messageEntity.getAuthor().getName(),
                    messageEntity.getAuthor().getLastName()
            );
            em.getTransaction().commit();
             return m;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return null;
    }

    public List<FeedMessageViewModel> getFeedFromUser(String email) {
        EntityManager em = emf.createEntityManager();
        List<FeedMessageEntity> resultQuery;
        try {
            TypedQuery<FeedMessageEntity> query = em.createNamedQuery("FeedMessageEntity.findByEmail", FeedMessageEntity.class);
            query.setParameter(1, email);
            resultQuery = query.getResultList();
            return FeedMessageConverter.convertToFMView(resultQuery);
        } catch (Exception e){
            System.out.println("Error in MDBHandler getting feed");
        }finally {
            em.close();
        }

        return null;
    }

    public DirectMessageViewModel addDirectMessage(DirectMessageEntity messageEntity, String senderEmail, String receiverEmail) {

        UserEntity sender;
        UserEntity receiver;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
            query.setParameter(1, senderEmail);
            sender = query.getSingleResult();
            query.setParameter(1, receiverEmail);
            receiver = query.getSingleResult();
            messageEntity.setSender(sender);
            messageEntity.setReceiver(receiver);
            em.persist(messageEntity);
            em.flush();
            DirectMessageViewModel m = new DirectMessageViewModel(
                    messageEntity.getSender().getName(),
                    messageEntity.getReceiver().getName(),
                    messageEntity.getMessage(),
                    messageEntity.getDate()
            );
            em.getTransaction().commit();
            return m;
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return null;
    }

    public List<DirectMessageViewModel> getDirectMessages(String userEmail_1, String userEmail_2) {
        EntityManager em = emf.createEntityManager();
        List<DirectMessageEntity> resultQuery;
        try{
            TypedQuery<DirectMessageEntity> query = em.createNamedQuery("DirectMessageEntity.findConversation", DirectMessageEntity.class);
            query.setParameter(1, userEmail_1);
            query.setParameter(2, userEmail_2);
            query.setParameter(3, userEmail_2);
            query.setParameter(4, userEmail_1);
            resultQuery = query.getResultList();
            return DirectMessageConverter.convertToDMView(resultQuery);
        } catch (Exception e) {
            System.out.println("Error getting DirectMessages in DB handler");
        } finally {
            em.close();
        }

        return null;
    }

}
