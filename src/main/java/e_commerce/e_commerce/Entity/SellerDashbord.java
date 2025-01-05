package e_commerce.e_commerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.OneToOne;

public class SellerDashbord {
    
    private Long totalOrders;
    private Long totalProducts;
    private Long totalUsers;    
    private Long totalRevenue;
    @JsonIgnore
    @OneToOne
    private Seller seller;
    public Long getTotalOrders() {
        return totalOrders;
    }
    public void setTotalOrders(final Long totalOrders) {
        this.totalOrders = totalOrders;
    }
    public Long getTotalProducts() {
        return totalProducts;
    }
    public void setTotalProducts(final Long totalProducts) {
        this.totalProducts = totalProducts;
    }
    public Long getTotalUsers() {
        return totalUsers;
    }
    public void setTotalUsers(final Long totalUsers) {
        this.totalUsers = totalUsers;
    }
    public Long getTotalRevenue() {
        return totalRevenue;
    }
    public void setTotalRevenue(final Long totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    public Seller getSeller() {
        return seller;
    }
    public void setSeller(final Seller seller) {
        this.seller = seller;
    }
    public SellerDashbord(final Long totalOrders, final Long totalProducts, final Long totalUsers, final Long totalRevenue, final Seller seller) {
        this.totalOrders = totalOrders;
        this.totalProducts = totalProducts;
        this.totalUsers = totalUsers;
        this.totalRevenue = totalRevenue;
        this.seller = seller;
    }
    public SellerDashbord() {
    }
    

}
