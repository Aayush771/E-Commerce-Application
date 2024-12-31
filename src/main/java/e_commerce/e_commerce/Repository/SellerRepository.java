package e_commerce.e_commerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import e_commerce.e_commerce.Entity.Seller;


public interface SellerRepository extends JpaRepository<Seller, Long> {

    Boolean existsByContactEmail(String email);
    Boolean existsByContactPhone(String contactPhone);
}
