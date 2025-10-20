package br.com.mercadinho.mercadinhosystem.Repository;

import br.com.mercadinho.mercadinhosystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
