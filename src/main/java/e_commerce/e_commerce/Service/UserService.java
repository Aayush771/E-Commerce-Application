package e_commerce.e_commerce.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import e_commerce.e_commerce.Entity.Address;
import e_commerce.e_commerce.Entity.Role;
import e_commerce.e_commerce.Entity.RoleName;
import e_commerce.e_commerce.Entity.User;
import e_commerce.e_commerce.Repository.RoleRepository;
import e_commerce.e_commerce.Repository.UserRepository;
@Service
public class UserService implements IUserService {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private RoleRepository roleRepository;
    @Override
   public String addUser(User user) {
    // Check if user already exists by email
    if(userRepository.existsByEmail(user.getEmail())) {
        return "User already exists";
    }

    // Fetch the default ROLE from the database using RoleName enum
    Role defaultRole = roleRepository.findByRoleName(RoleName.USER); // Using the enum value
    if (defaultRole == null) {
        return "Default role 'USER' does not exist!";
    }

    // Set the default role (USER) for the new user
    Set<Role> roles = new HashSet<>();
    roles.add(defaultRole);

    user.setUserRoleRoles(roles); // Assign default role to user
    user.setUserCarts(new HashSet<>());

    // Save the user
    userRepository.save(user);

    return "User added successfully";
}

    
    @Override
    public String updateUser(User user) {
        // TODO Auto-generated method stub
        User user2 = userRepository.findById(user.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));

       if(user.getFirstName() != null) {
           user2.setFirstName(user.getFirstName()); 
       }

       if(user.getLastName() != null) { 
           user2.setLastName(user.getLastName());
       }        

       if(user.getEmail() != null) {
           user2.setEmail(user.getEmail());                  
       }

       if(user.getPassword() != null) {
           user2.setPassword(user.getPassword());          
       }

       if(user.getMobileNumber() != null) {
           user2.setMobileNumber(user.getMobileNumber());
       }

       userRepository.save(user2);
       return "User updated successfully";

    }

    @Override
    public String deleteUser(Long userId) {
        // TODO Auto-generated method stub
      userRepository.deleteById(userId);
      return "User deleted successfully";
    }

    @Override
    public User getUser(Long userId) {
        // TODO Auto-generated method stub
      return userRepository.findById(userId).get();
      
    }

    @Override
    public User getUser(String email) {
        // TODO Auto-generated method stub
       return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
      return userRepository.findAll();
    }

    @Override
    public List<Address> getUserAddress(Long userId) {
        // TODO Auto-generated method stub
        return new ArrayList<Address>(userRepository.findById(userId).get().getUserAddresses());
    }
    
}
