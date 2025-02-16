package quickcart.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Seller;


public interface SellerRepository extends JpaRepository<Seller, Long> {

    Boolean existsByContactEmail(String email);
    Boolean existsByContactPhone(String contactPhone);
}
