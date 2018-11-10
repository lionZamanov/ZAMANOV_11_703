package ru.itis;

import java.io.IOException;
import java.util.List;

public interface UsersRepository {
    void save(User user);
    void deleteByLogin(String login);
    User findByLogin(String login) throws IOException;
    List<User> findAll();
}
