package quickcart.quickcart.Service;

import java.util.List;

import quickcart.quickcart.Entity.Seller;

public interface ISellerService {
    String addSeller(final Seller seller);
    String updateSeller(final Seller seller);  
    String deleteSeller(final Long sellerId);
    Seller getSeller(final Long sellerId);
    List<Seller> getAllSellers();
   
}
