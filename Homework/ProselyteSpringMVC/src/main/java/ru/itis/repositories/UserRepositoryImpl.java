package ru.itis.repositories;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Auth;
import ru.itis.models.User;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements  UserRepository {

    private EntityManager entityManager;

    @Autowired
    AuthRepository authRepository;

    public UserRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public User find(Long id) {
        return entityManager.find(User.class, id);
    }

    public User findByName(String name) {
        return entityManager.createQuery("FROM User u WHERE u.userName = :name", User.class).setParameter("name", name).getSingleResult();
    }

    public User getByCookie(String cookie) {
        Auth auth = authRepository.findByCookieValue(cookie);
        return find(auth.getId());
    }

    public List<User> findAll() {
        TypedQuery<User> typedQuery = entityManager.createQuery("from User ", User.class);
        return typedQuery.getResultList();
    }

    public void save(User model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        User user = find(id);
        entityManager.remove(user);
    }

    public void update(User model) {

    }
}
