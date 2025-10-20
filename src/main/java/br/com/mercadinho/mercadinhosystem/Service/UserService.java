package br.com.mercadinho.mercadinhosystem.Service;

import br.com.mercadinho.mercadinhosystem.Model.User;
import br.com.mercadinho.mercadinhosystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id) {

    }
}
