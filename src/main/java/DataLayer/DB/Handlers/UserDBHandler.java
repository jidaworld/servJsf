package DataLayer.DB.Handlers;

import BusinessLayer.Entities.UserEntity;
import BusinessLayer.ViewModels.UserViewModel;
import DataLayer.DB.IHandlers.IUserHandler;
import DataLayer.DB.Util.UserConverter;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

public class UserDBHandler implements IUserHandler {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");

    public UserDBHandler() {

    }

    public void addUser(UserEntity Users) throws IllegalArgumentException, EntityExistsException{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(Users);
            em.getTransaction().commit();
        } catch (EntityExistsException e){
            System.out.println("exists");
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }

    }

    public List<UserViewModel> getUsers(String name) {
        EntityManager em = emf.createEntityManager();
        List<UserEntity> resultQuery;

        TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findAllButMe", UserEntity.class);
        query.setParameter(1, name);
        resultQuery = query.getResultList();
        em.close();

        return UserConverter.convertToUserView(resultQuery);
    }

    public boolean loginUser(String email, String password){
        EntityManager em = emf.createEntityManager();
        UserEntity userEntity;

        TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findByEmail", UserEntity.class);
        query.setParameter(1, email);
        userEntity = query.getSingleResult();
        em.close();
        if (userEntity != null) {
            return BCrypt.checkpw(password, userEntity.getPassword());
        }

        return false;
    }
}
