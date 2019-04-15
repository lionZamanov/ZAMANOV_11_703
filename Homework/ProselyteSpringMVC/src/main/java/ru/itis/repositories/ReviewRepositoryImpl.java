package ru.itis.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.models.Review;

import javax.persistence.*;
import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    private EntityManager entityManager;

    public ReviewRepositoryImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Review find(Long id) {
        return entityManager.find(Review.class, id);
    }

    public List<Review> findAll() {
        TypedQuery<Review> typedQuery = entityManager.createQuery("from Review", Review.class);
        return typedQuery.getResultList();
    }

    public void save(Review model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Review user = find(id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public void update(Review model) {

    }
}
