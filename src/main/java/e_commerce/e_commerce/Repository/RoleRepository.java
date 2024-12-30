package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Role;
import e_commerce.e_commerce.Entity.RoleName;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
