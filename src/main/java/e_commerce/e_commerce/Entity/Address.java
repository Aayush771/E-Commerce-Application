package e_commerce.e_commerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Addresses")
@EntityListeners(AuditingEntityListener.class)
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column
    private String buildingName;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String pincode;

    @Column
    private String state;

    @Column
    private String street;

    @ManyToMany(mappedBy = "userAddresses")
    private Set<Users> userAddressUsers;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(final Long addressId) {
        this.addressId = addressId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(final String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(final String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public Set<Users> getUserAddressUsers() {
        return userAddressUsers;
    }

    public void setUserAddressUsers(final Set<Users> userAddressUsers) {
        this.userAddressUsers = userAddressUsers;
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

}
