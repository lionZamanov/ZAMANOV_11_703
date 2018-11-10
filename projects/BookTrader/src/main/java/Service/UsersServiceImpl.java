package Service;

import Models.User;
import Repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public class    UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    private BCryptPasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean register(User user) {
        user.setHashPassword(passwordEncoder.encode(user.getRawPassword()));
        user.setRawPassword(null);
        Date date = new Date();
        user.setRegistered(date.toString());
        if(!isRegistered(user)){
            usersRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean isRegistered(User user) {
        User existedUser = usersRepository.findOneByEmail(user.getEmail());
        if (existedUser != null) {
            if (passwordEncoder.matches(user.getRawPassword(),
                    existedUser.getHashPassword())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public User userBuilder(String email, String password) {
        if(isRegistered(User.builder().email(email).rawPassword(password).build())){
            return usersRepository.findOneByEmail(email);
        }
        return null;
    }
}
