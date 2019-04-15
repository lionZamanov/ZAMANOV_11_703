package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.models.Review;
import ru.itis.models.User;
import ru.itis.services.UserService;
import ru.itis.services.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class Main {

    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = new User();
        user.setUserName("fsesf");
        Review review = new Review();
        review.setTitle("zdarova");
        review.setText("zdarova");
        review.setUser(user);
        entityManager.persist(user);
        entityManager.persist(review);
        entityManager.getTransaction().commit();
    }
}