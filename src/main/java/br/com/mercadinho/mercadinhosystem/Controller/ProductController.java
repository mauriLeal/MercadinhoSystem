package br.com.mercadinho.mercadinhosystem.Controller;

import br.com.mercadinho.mercadinhosystem.Model.Product;
import br.com.mercadinho.mercadinhosystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Product getProduct = productService.findProductById(id);
        return ResponseEntity.ok(getProduct);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

