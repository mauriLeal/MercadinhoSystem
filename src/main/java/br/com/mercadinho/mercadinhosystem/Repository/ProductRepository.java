package br.com.mercadinho.mercadinhosystem.Repository;

import br.com.mercadinho.mercadinhosystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
