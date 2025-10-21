package br.com.mercadinho.mercadinhosystem.Controller;


import br.com.mercadinho.mercadinhosystem.Dto.UserCreateDTO;
import br.com.mercadinho.mercadinhosystem.Dto.UserResponseDTO;
import br.com.mercadinho.mercadinhosystem.Dto.UserUpdateDTO;
import br.com.mercadinho.mercadinhosystem.Model.Product;
import br.com.mercadinho.mercadinhosystem.Model.User;
import br.com.mercadinho.mercadinhosystem.Service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserCreateDTO userDTO){
        UserResponseDTO newUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long id){
        UserResponseDTO userDTO = userService.findUserAsDtoById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,@Valid @RequestBody UserUpdateDTO userDTO){
        UserResponseDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
