package quickcart.quickcart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

    boolean  existsByEmail(String email);
    Optional<Users> findByEmail(String email);
}
