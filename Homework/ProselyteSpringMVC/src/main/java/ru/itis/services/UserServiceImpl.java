package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.models.Auth;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    AuthRepository authRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(Long id) {
        return userRepository.find(id);
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.delete(id);
    }

    public void edit(User user) {
        userRepository.update(user);
    }


    public void signUp(SignUpForm form) {
        User user = User.builder()
                .userName(form.getUserName())
                .passwordHash(encoder.encode(form.getPassword()))
                .email(form.getEmail())
                .build();

        userRepository.save(user);
    }

    public String signIn(SignInForm form) {
        User user = userRepository.findByName(form.getName());
        if (user != null && encoder.matches(form.getPassword(), user.getPasswordHash())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .userId(user.getId())
                    .cookieValue(cookieValue)
                    .build();

            authRepository.save(auth);
            return cookieValue;
        }
        return null;
    }
}
