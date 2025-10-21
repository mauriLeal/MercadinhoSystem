package br.com.mercadinho.mercadinhosystem.Repository;

import br.com.mercadinho.mercadinhosystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByProductNameIgnoreCase(String productName);
}
