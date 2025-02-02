package e_commerce.e_commerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.Address;
import e_commerce.e_commerce.Entity.User;
import e_commerce.e_commerce.Service.IUserService;
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
    public String addUser(@RequestBody User entity) {
        return userService.addUser(entity);
    }
    @PutMapping("users/{id}")
    public String updateUser(@RequestBody User entity) {

        return userService.updateUser(entity);
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }
@GetMapping
public User getUser(@RequestParam(required = false) String email, 
                    @RequestParam(required = false) Long id) {
    if (email != null) {
        return userService.getUser(email);
    } else if (id != null) {
        return userService.getUser(id);
    } else {
        throw new IllegalArgumentException("Either email or id must be provided.");
    }
}

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("users/{userId}/addresses")
    public List<Address> getUserAddress(@PathVariable Long userId) {
        return userService.getUserAddress(userId);
    }
}
