package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.models.Review;
import ru.itis.repositories.ReviewRepository;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review get(Long id) {
        return reviewRepository.find(id);
    }

    public void add(Review review) {
        reviewRepository.save(review);
    }

    public void delete(Long id) {
        reviewRepository.delete(id);
    }

    public void edit(Review review) {
        reviewRepository.update(review);
    }
}
