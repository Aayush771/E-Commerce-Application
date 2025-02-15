package e_commerce.e_commerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

    boolean  existsByEmail(String email);
    Optional<Users> findByEmail(String email);
}
