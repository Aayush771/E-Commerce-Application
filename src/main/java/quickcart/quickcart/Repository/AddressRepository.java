package quickcart.quickcart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quickcart.quickcart.Entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
