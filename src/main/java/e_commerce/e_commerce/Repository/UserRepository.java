package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean  existsByEmail(String email);
}
