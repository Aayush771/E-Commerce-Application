package quickcart.quickcart.Service;

import java.util.List;

import quickcart.quickcart.Entity.Address;
import quickcart.quickcart.Entity.Users;
public interface IUserService {
    String addUser(Users user);
    String updateUser(Users user);
    String deleteUser(Long userId);  
    Users getUser(Long userId);
    Users getUser(String email);
    Users makeUserAdmin(String email);
    List<Users> getAllUsers();
    List<Address> getUserAddress(Long userId);
}
