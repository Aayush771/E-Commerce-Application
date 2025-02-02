package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Address;
import e_commerce.e_commerce.Entity.User;

public interface IUserService {
    String addUser(User user);
    String updateUser(User user);
    String deleteUser(Long userId);  
    User getUser(Long userId);
    User getUser(String email);
    List<User> getAllUsers();
    List<Address> getUserAddress(Long userId);
}
