package DataLayer.DB.Handlers;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;
import DataLayer.DB.IHandlers.IUserHandler;
import DataLayer.DB.Util.UserConverter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDBHandler implements IUserHandler {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");

    public UserDBHandler(){

    }

    public void addUser(UserEntity Users) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(Users);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }

    public List<UserViewModel> getUsers(String name){
        EntityManager em = emf.createEntityManager();
        List<UserEntity> resultQuery;
        try{
            TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findByName",UserEntity.class);
            query.setParameter(1, "%" + name + "%");
            resultQuery = query.getResultList();
            return UserConverter.convertToUserView(resultQuery);
        } catch(Exception e){
            System.out.println("Error getting users");
        } finally {
            em.close();
        }

        return null;
    }
}
