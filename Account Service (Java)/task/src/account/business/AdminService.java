package account.business;

import account.controller.dto.ChangeUserLockDto;
import account.entities.User;

import java.util.List;

public interface AdminService {
    int MAX_FAILED_ATTEMPTS = 5;
    List<User> getAllUsers();
    User getUserByUsername(String username);
    void deleteUser(String username, User requester);
    User grantRole(String role, String username, User requester);
    User removeRole(String role, String username, User requester);
    void lockUser(ChangeUserLockDto changeUserLockDto, User requester);
    void unlockUser(ChangeUserLockDto changeUserLockDto, User requester);
    void increaseFailedAttempts(User user);
    void resetFailedAttempts(String username);
    boolean hasAdminRole(User user);
    void bruteForceLockUser(User user);
}
