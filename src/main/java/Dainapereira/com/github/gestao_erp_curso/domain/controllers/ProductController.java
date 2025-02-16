package Dainapereira.com.github.gestao_erp_curso.domain.controllers;

import Dainapereira.com.github.gestao_erp_curso.domain.Enums.ProductType;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/products")

public class ProductController {
  private final ProductService productService;
  public ProductController(ProductService productService){
    this.productService=productService;
  }
  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<Void>createProducts(@RequestBody @Valid ProductRequestDTO productDTO){
    ProductResponseDTO savedProduct = productService.createProductDTO(productDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedProduct.id()).toUri();

    return ResponseEntity.created(uri).build();
  }
  @GetMapping(produces = "application/json",path ="/{id}")
  public ResponseEntity<ProductResponseDTO>getProduct(@PathVariable Long id){
    ProductResponseDTO product = productService.findById(id);

    if (product==null){
      return ResponseEntity.badRequest().build();
    }
      return ResponseEntity.ok(product);

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<ProductResponseDTO>>getAllProducts(){
    List<ProductResponseDTO> products = productService.findAll();
    return ResponseEntity.ok(products);
    }
  @PutMapping(consumes = "application/json", produces = "application/json",path = "/{id}")
  public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,
    @Valid @RequestBody ProductUpdateRequestDTO productDTO) {
    ProductResponseDTO result = productService.updateProduct(id, productDTO);
    return ResponseEntity.ok(result);
    }
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id ){
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
    }
  }

}
