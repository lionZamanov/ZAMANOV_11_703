package ru.itis.services;

import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User get(Long id);
    void add(User user);
    void remove(Long id);
    void edit(User user);
    void signUp(SignUpForm form);
    String signIn(SignInForm form);
}
