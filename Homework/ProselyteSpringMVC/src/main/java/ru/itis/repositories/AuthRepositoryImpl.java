package ru.itis.repositories;


import org.springframework.stereotype.Repository;
import ru.itis.models.Auth;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
    private EntityManager entityManager;

    public AuthRepositoryImpl(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Auth findByCookieValue(String cookieValue) {
        return entityManager.createQuery("from Auth a where a.cookieValue = :cookieValue", Auth.class).setParameter("cookieValue", cookieValue).getSingleResult();
    }

    public List<Auth> findAll() {
        return null;
    }

    public Auth find(Long id) {
        return null;
    }

    public void save(Auth model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {

    }

    public void update(Auth model) {

    }
}
