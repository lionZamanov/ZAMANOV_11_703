package ru.itis.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.forms.SignInForm;
import ru.itis.forms.SignUpForm;
import ru.itis.models.Auth;
import ru.itis.models.Product;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.ProductRepository;
import ru.itis.repositories.ProductRepositoryImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.models.User;

import java.util.UUID;

/**
 * 25.10.2018
 * UsersServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersServiceImpl implements UsersService {

    private PasswordEncoder encoder;

    private UsersRepository usersRepository;
    private AuthRepository authRepository;

    public UsersServiceImpl(UsersRepository usersRepository, AuthRepository authRepository) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .name(form.getName())
                .passwordHash(encoder.encode(form.getPassword()))
                .age(form.getAge())
                .build();

        usersRepository.save(user);
    }

    @Override
    public String signIn(SignInForm form) {
        User user = usersRepository.findByName(form.getName());

        if (user != null && encoder.matches(form.getPassword(), user.getPasswordHash())) {
            String cookieValue = UUID.randomUUID().toString();

            Auth auth = Auth.builder()
                    .user(user)
                    .cookieValue(cookieValue)
                    .build();

            authRepository.save(auth);

            return cookieValue;
        }
        return null;
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        if (authRepository.findByCookieValue(cookieValue) != null) {
            return true;
        }
        return false;
    }

    public boolean addProduct(User user, Product product) {
        return usersRepository.addProduct(user, product);
    }

    @Override
    public User getUserByCookie(String cookie) {
        return usersRepository.finByCookie(cookie);
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.find(id);
    }
}
