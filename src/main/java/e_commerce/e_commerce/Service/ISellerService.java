package e_commerce.e_commerce.Service;

import java.util.List;

import e_commerce.e_commerce.Entity.Seller;

public interface ISellerService {
    String addSeller(final Seller seller);
    String updateSeller(final Seller seller);  
    String deleteSeller(final Long sellerId);
    Seller getSeller(final Long sellerId);
    List<Seller> getAllSellers();
}
