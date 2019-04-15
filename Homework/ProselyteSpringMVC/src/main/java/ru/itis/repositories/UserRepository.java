package ru.itis.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.models.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User>{
    User findByName(String name);
    User getByCookie(String cookie);
}
