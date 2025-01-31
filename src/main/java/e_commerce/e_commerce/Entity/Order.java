package e_commerce.e_commerce.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column
    private String email;
    
    @Column
    private LocalDate orderDate;

    @Column
    private  OrderStatus orderStatus = OrderStatus.PENDING;

    @Column
    private Double totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderOrderItems;  
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final LocalDate orderDate) {
        this.orderDate = orderDate;
    }
 

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Set<OrderItem> getOrderOrderItems() {
        return orderOrderItems;
    }

    public void setOrderOrderItems(final Set<OrderItem> orderOrderItems) {
        this.orderOrderItems = orderOrderItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(final Payment payment) {
        this.payment = payment;
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

    public enum OrderStatus {
        PENDING, PLACED, FAILED
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(Long orderId, String email, LocalDate orderDate, OrderStatus orderStatus, Double totalAmount,
            Set<OrderItem> orderOrderItems, Payment payment, Seller seller, OffsetDateTime dateCreated,
            OffsetDateTime lastUpdated) {
        this.orderId = orderId;
        this.email = email;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.orderOrderItems = orderOrderItems;
        this.payment = payment;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public Order() {

    }

}
