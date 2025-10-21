package br.com.mercadinho.mercadinhosystem.Service;

import br.com.mercadinho.mercadinhosystem.Dto.UserCreateDTO;
import br.com.mercadinho.mercadinhosystem.Dto.UserResponseDTO;
import br.com.mercadinho.mercadinhosystem.Dto.UserUpdateDTO;
import br.com.mercadinho.mercadinhosystem.Model.User;
import br.com.mercadinho.mercadinhosystem.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO createUser(UserCreateDTO userDTO){
        User newUser = new User();
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());

        User savedUser = userRepository.save(newUser);
        return new UserResponseDTO(savedUser);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: "+ id));
    }
    
    public UserResponseDTO findUserAsDtoById(Long id){
        User user = this.findUserById(id);
        return new UserResponseDTO(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public UserResponseDTO updateUser(Long id, UserUpdateDTO userDTO){
        User existingUser = findUserById(id);

        if(userDTO.getName() != null ){
            existingUser.setName(userDTO.getName());
        }

        if(userDTO.getEmail() != null){
            existingUser.setEmail(userDTO.getEmail());
        }

        return new UserResponseDTO(existingUser);
    }

    @Transactional
    public void deleteUser(Long id){
        User deleteUser = findUserById(id);
        userRepository.delete(deleteUser);
    }

}
