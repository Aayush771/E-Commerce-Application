package quickcart.quickcart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import quickcart.quickcart.Entity.Address;
import quickcart.quickcart.Entity.Users;
import quickcart.quickcart.Service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("users")
    public String addUser(@RequestBody Users entity) {
        return userService.addUser(entity);
    }
    @PutMapping("users")
    public String updateUser(@RequestBody Users entity) {

        return userService.updateUser(entity);
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }
    @GetMapping("users/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUser(id);
    }

    
    @GetMapping("users/email")
    public Users getUserByEmail(@RequestParam String email) {
        return userService.getUser(email);
    }
    @GetMapping("users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("users/{userId}/addresses")
    public List<Address> getUserAddress(@PathVariable Long userId) {
        return userService.getUserAddress(userId);
    }

    @PutMapping("users/{email}/admin")
    public Users makeUserAdmin(@PathVariable String email) {
        return userService.makeUserAdmin(email);
    }
    @PostMapping("users/login")
    public String login(@RequestParam String email,@RequestParam String password) {
        return "Success";
    }
}
