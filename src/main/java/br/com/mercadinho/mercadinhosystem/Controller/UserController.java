package br.com.mercadinho.mercadinhosystem.Controller;


import br.com.mercadinho.mercadinhosystem.Model.Product;
import br.com.mercadinho.mercadinhosystem.Model.User;
import br.com.mercadinho.mercadinhosystem.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User getUser = userService.findUserById(id);
        return ResponseEntity.ok(getUser);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return usService.findAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
