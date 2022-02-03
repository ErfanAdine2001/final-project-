package repository;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepository implements BaseRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
    EntityManager manager = entityManagerFactory.createEntityManager();

    public UserRepository() {
    }

    public UserRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public User getUserById(Integer id) {
//        manager.getTransaction().begin();
        return manager.find(User.class, id);
    }

    @Override
    public User saveUser(User b) {
//        if (b.getId() == null) {
        manager.getTransaction().begin();
        manager.persist(b);
        manager.getTransaction().commit();
        return b;

//        } else {
//            b = manager.merge(b);
//        }
//
//        return b;
    }


    @Override
    public void deleteUser(Integer id) {

        manager.detach(getUserById(id));

    }
}
