package e_commerce.e_commerce.Service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import e_commerce.e_commerce.Entity.Role;
import e_commerce.e_commerce.Entity.RoleName;
import e_commerce.e_commerce.Repository.RoleRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check and add roles if they don't exist
        for (RoleName roleName : RoleName.values()) {
            if (roleRepository.findByRoleName(roleName) == null) {
                Role role = new Role();
                role.setRoleName(roleName);
                roleRepository.save(role);
            }
        }
    }
}

