package services.interfaces;
import models.Users.User;

public interface UserService {
    public User login(String username,String password);
}
