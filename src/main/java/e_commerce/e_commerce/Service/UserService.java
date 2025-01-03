package e_commerce.e_commerce.Service;

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
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public String deleteUser(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public User getUser(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public User getUser(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public List<Address> getUserAddress(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserAddress'");
    }
    
}
