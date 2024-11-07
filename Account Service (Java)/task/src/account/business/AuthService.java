package account.business;

import account.entities.User;

public interface AuthService {
    User registerUser (User user);
    void changePassword (User user, String newPassword);
}
