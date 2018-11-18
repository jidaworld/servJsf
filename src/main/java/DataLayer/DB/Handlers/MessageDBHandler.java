package DataLayer.DB.Handlers;

import BusinessLayer.Entities.DirectMessageEntity;
import BusinessLayer.Entities.FeedMessageEntity;
import BusinessLayer.ViewModels.DirectMessageViewModel;
import BusinessLayer.ViewModels.FeedMessageViewModel;
import DataLayer.DB.IHandlers.IMessageHandler;
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

    public FeedMessageViewModel addFeedMessage(FeedMessageEntity messageEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(messageEntity);
            em.getTransaction().commit();
            // return new FeedMessageViewModel blabla
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return null;
    }

    public List<FeedMessageViewModel> getFeedFromUser(String email) {
        EntityManager em = emf.createEntityManager();
        List<FeedMessageEntity> resultQuery = null;
        try{
            TypedQuery<FeedMessageEntity> query = em.createNamedQuery("FeedMessageEntity.findByEmail", FeedMessageEntity.class);
            query.setParameter(1, "%" + email + "%");
            resultQuery = query.getResultList();
            return FeedMessageConverter.convertToFMView(resultQuery);
        } catch (Exception e){
            System.out.println("Error in MDBHandler getting feed");
        }finally {
            em.close();
        }

        return null;
    }

    public DirectMessageViewModel addDirectMessage(DirectMessageEntity messageEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(messageEntity);
            em.getTransaction().commit();
            // return new FeedMessageViewModel ..
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return null;
    }

    public List<DirectMessageViewModel> getDirectMessages(String user_1, String user_2) {
        return null;
    }

}
