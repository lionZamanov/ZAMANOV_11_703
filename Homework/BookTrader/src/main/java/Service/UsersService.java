package Service;

import Models.User;

public interface UsersService {
    boolean register(User user);
    boolean isRegistered(User user);
    User userBuilder(String email, String password);
}
