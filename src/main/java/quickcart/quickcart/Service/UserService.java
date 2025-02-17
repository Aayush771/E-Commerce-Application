package quickcart.quickcart.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import quickcart.quickcart.Entity.Address;
import quickcart.quickcart.Entity.Role;
import quickcart.quickcart.Entity.RoleName;
import quickcart.quickcart.Entity.Users;
import quickcart.quickcart.Exception.UserException;
import quickcart.quickcart.Repository.RoleRepository;
import quickcart.quickcart.Repository.UserRepository;


@Service
public class UserService implements IUserService {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private RoleRepository roleRepository;
   @Autowired
  private PasswordEncoder pEncoder;
    @Override
   public String addUser(Users user) {
    
    if(userRepository.existsByEmail(user.getEmail())) {
        return "User already exists with email: "+ user.getEmail();
    }

    
    Role defaultRole = roleRepository.findByRoleName(RoleName.ROLE_USER).orElseThrow(()-> new UserException("Default role 'USER' does not exist!")); 
    if (defaultRole == null) {
        return "Default role 'USER' does not exist!";
    }

   
    Set<Role> roles = new HashSet<>();
    roles.add(defaultRole);
    user.setPassword(pEncoder.encode(user.getPassword()));
    user.setUserRoleRoles(roles); 
    user.setUserCarts(new HashSet<>());

    // Save the user
    userRepository.save(user);

    return "User added successfully";
}

    
    @Override
    public String updateUser(Users user) {
        // TODO Auto-generated method stub
        Users user2 = userRepository.findById(user.getUserId()).orElseThrow(()-> new UserException("User not found"));

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
    public Users getUser(Long userId) {
        // TODO Auto-generated method stub
      return userRepository.findById(userId).get();
      
    }

    @Override
    public Users getUser(String email) {
        // TODO Auto-generated method stub
       return userRepository.findByEmail(email).orElseThrow(()-> new UserException("User not found with email: " + email));
    }

    @Override
    public List<Users> getAllUsers() {
        // TODO Auto-generated method stub
      return userRepository.findAll();
    }

    @Override
    public List<Address> getUserAddress(Long userId) {
        // TODO Auto-generated method stub
        return new ArrayList<Address>(userRepository.findById(userId).get().getUserAddresses());
    }


    @Override
    public Users makeUserAdmin(String email) {
        // TODO Auto-generated method stub
        Users user = getUser(email);
        user.getUserRoleRoles().add(roleRepository.findByRoleName(RoleName.ROLE_ADMIN).get());
        return userRepository.save(user);
    }

    
}
