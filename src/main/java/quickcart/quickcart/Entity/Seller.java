package quickcart.quickcart.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

import java.time.OffsetDateTime;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Sellers")
@EntityListeners(AuditingEntityListener.class)
public class Seller {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    @Column
    private String storeName;

    @Column
    private String storeDescription;

    @Email
    private String contactEmail;

    @Column(length = 10)
    private String contactPhone;
    @JsonIgnore
    @OneToMany(mappedBy = "seller")
    private Set<Product> sellerProducts;
     @JsonIgnore
    @OneToMany(mappedBy = "seller")
    private Set<OrderItem> sellerOrders;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(final Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(final String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(final String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(final String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(final String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Set<Product> getSellerProducts() {
        return sellerProducts;
    }

    public void setSellerProducts(final Set<Product> sellerProducts) {
        this.sellerProducts = sellerProducts;
    }

   
    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<OrderItem> getSellerOrders() {
        return sellerOrders;
    }

    public void setSellerOrders(Set<OrderItem> sellerOrders) {
        this.sellerOrders = sellerOrders;
    }

}
