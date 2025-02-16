package quickcart.quickcart.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import quickcart.quickcart.Entity.Users;
import quickcart.quickcart.Repository.UserRepository;

@Configuration
public class UserDetail implements UserDetailsService{
  
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        // TODO Auto-generated method stub

        Set<GrantedAuthority> authorities =  Set.of(new SimpleGrantedAuthority(user.getUserRoleRoles().toString()));
      
        
        UserDetails userDetails = User.withUsername(user.getEmail()).password(user.getPassword()).authorities(authorities).build();
        return userDetails;
    }
    
}
