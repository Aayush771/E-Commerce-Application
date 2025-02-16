package quickcart.quickcart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Role;
import quickcart.quickcart.Entity.RoleName;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
