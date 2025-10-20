package br.com.mercadinho.mercadinhosystem.Service;

import br.com.mercadinho.mercadinhosystem.Model.User;
import br.com.mercadinho.mercadinhosystem.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: "+ id));
    }

    public User updateUser(Long id, User userDetails){
        User existingUser = findUserById(id);

        if(userDetails.getName() != null ){
            existingUser.setName(userDetails.getName());
        }

        if(userDetails.getEmail() != null){
            existingUser.setEmail(userDetails.getEmail());
        }

        if(userDetails.getPassword() != null){
            existingUser.setPassword(userDetails.getPassword());
        }

        return userRepository.save(existingUser);
    }

    public Void deleteUser(Long id){
        User deleteUser = findUserById(id);
        userRepository.delete(deleteUser);

    }

}
