package APP.APPLICATION.CONTROLLER;


import APP.APPLICATION.MODELS.Products;
import APP.APPLICATION.POJOS.ProductPojo;
import APP.APPLICATION.REPOSITORY.ProductRepository;
import APP.APPLICATION.SERVICES.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/employee/product/create")
    public void createProduct(@RequestBody ProductPojo productPojo){
        productService.createProduct(productPojo);
    }

    @GetMapping(value = "/employee/product/getAll")
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping(value = "employee/product/{id}/delete")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @PutMapping(value = "employee/product/{id}/edit")
    public void editProduct(@PathVariable Long id, @RequestBody ProductPojo productPojo){
        productService.editProduct(id, productPojo);
    }

    @PutMapping(value = "employee/product/{id}/buy")
    public void buyProduct(@PathVariable Long id, @RequestBody ProductPojo productPojo){
        productService.buyProduct(id, productPojo);
    }

}
