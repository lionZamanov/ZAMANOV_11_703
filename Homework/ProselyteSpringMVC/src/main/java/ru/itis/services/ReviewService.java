package ru.itis.services;

import ru.itis.models.Review;


import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review get(Long id);
    void add(Review review);
    void delete(Long id);
    void edit(Review review);
}
