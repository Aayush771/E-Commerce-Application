package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Address;
import e_commerce.e_commerce.Entity.Users;

public interface IUserService {
    String addUser(Users user);
    String updateUser(Users user);
    String deleteUser(Long userId);  
    Users getUser(Long userId);
    Users getUser(String email);
    List<Users> getAllUsers();
    List<Address> getUserAddress(Long userId);
}
