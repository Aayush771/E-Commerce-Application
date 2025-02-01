// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.when;
// import java.util.Optional;
// import java.util.Set;
// import java.util.HashSet;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import e_commerce.e_commerce.Entity.Cart;
// import e_commerce.e_commerce.Entity.Order;
// import e_commerce.e_commerce.Entity.OrderItem;
// import e_commerce.e_commerce.Entity.Product;
// import e_commerce.e_commerce.Entity.User;
// import e_commerce.e_commerce.Repository.OrderRepository;






// public class OrderServiceTest {

//     @InjectMocks
//     private OrderService orderService;

//     @Mock
//     private OrderRepository orderRepository;

//     @Mock
//     private ICartService cartService;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testCreateOrder_Success() {
//         Long cartId = 1L;
//         Cart cart = new Cart();
//         User user = new User();
//         user.setEmail("test@example.com");
//         cart.setUser(user);

//         Product product = new Product();
//         product.setProductId(1L);
//         product.setSeller(new User());

//         OrderItem orderItem = new OrderItem();
//         orderItem.setProduct(product);
//         orderItem.setDiscount(10.0);
//         orderItem.setItemTotalPrice(100.0);
//         orderItem.setOrderedProductPrice(90.0);
//         orderItem.setQuantity(1);

//         Set<OrderItem> cartItems = new HashSet<>();
//         cartItems.add(orderItem);
//         cart.setCartCartItems(cartItems);

//         when(cartService.getCart(cartId)).thenReturn(Optional.of(cart));
//         when(orderRepository.save(new Order())).thenReturn(new Order());

//         Order order = orderService.createOrder(cartId);

//         assertEquals("test@example.com", order.getEmail());
//         assertEquals(1, order.getOrderOrderItems().size());
//         assertEquals(100.0, order.getTotalAmount());
//     }

//     @Test
//     public void testCreateOrder_CartNotFound() {
//         Long cartId = 1L;
//         when(cartService.getCart(cartId)).thenReturn(Optional.empty());

//         RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//             orderService.createOrder(cartId);
//         });

//         assertEquals("Cart not found for id: 1", exception.getMessage());
//     }

//     @Test
//     public void testCreateOrder_SellerNotFound() {
//         Long cartId = 1L;
//         Cart cart = new Cart();
//         User user = new User();
//         user.setEmail("test@example.com");
//         cart.setUser(user);

//         Product product = new Product();
//         product.setProductId(1L);

//         OrderItem orderItem = new OrderItem();
//         orderItem.setProduct(product);
//         orderItem.setDiscount(10.0);
//         orderItem.setItemTotalPrice(100.0);
//         orderItem.setOrderedProductPrice(90.0);
//         orderItem.setQuantity(1);

//         Set<OrderItem> cartItems = new HashSet<>();
//         cartItems.add(orderItem);
//         cart.setCartCartItems(cartItems);

//         when(cartService.getCart(cartId)).thenReturn(Optional.of(cart));

//         RuntimeException exception = assertThrows(RuntimeException.class, () -> {
//             orderService.createOrder(cartId);
//         });

//         assertEquals("Seller not found for product: 1", exception.getMessage());
//     }
// }