package e_commerce.e_commerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import e_commerce.e_commerce.Entity.User;
import e_commerce.e_commerce.Service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("users")
    public String addUser(@RequestBody User entity) {
        return userService.addUser(entity);
    }
    
    
}
