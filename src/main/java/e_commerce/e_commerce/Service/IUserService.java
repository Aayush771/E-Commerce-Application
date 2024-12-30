package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Address;
import e_commerce.e_commerce.Entity.User;

public interface IUserService {
    String addUser(final User user);
    String updateUser(final User user);
    String deleteUser(final Long userId);  
    User getUser(final Long userId);
    User getUser(final String email);
    List<User> getAllUsers();
    List<Address> getUserAddress(final Long userId);
}
