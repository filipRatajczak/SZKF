package APP.APPLICATION.SERVICES;


import APP.APPLICATION.MODELS.Client;
import APP.APPLICATION.MODELS.Payments;
import APP.APPLICATION.MODELS.Products;
import APP.APPLICATION.POJOS.ProductPojo;
import APP.APPLICATION.REPOSITORY.ClientRepository;
import APP.APPLICATION.REPOSITORY.PaymentRepository;
import APP.APPLICATION.REPOSITORY.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final PaymentRepository paymentRepository;

    public ProductService(ProductRepository productRepository, ClientRepository clientRepository, PaymentRepository paymentRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public void createProduct(ProductPojo productPojo) {
        Products products = new Products();
        products.setProductName(productPojo.getProductName());
        products.setPrice(productPojo.getPrice());
        productRepository.save(products);
    }

    @Transactional
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void editProduct(Long id, ProductPojo productPojo) {
        Optional<Products> products = productRepository.findById(id);

        products.ifPresent(e -> {
            e.setProductName(productPojo.getProductName());
            e.setPrice(productPojo.getPrice());
        });
    }

    @Transactional
    public void buyProduct(Long id, ProductPojo productPojo) {
        Optional<Products> products = productRepository.findByProductName(productPojo.getProductName());
        Optional<Client> client = clientRepository.findById(id);

        if (products.isPresent() && client.isPresent()) {
            if (client.get().getWallet().compareTo(products.get().getPrice()) >= 0) {
                client.get().setWallet(client.get().getWallet().subtract(products.get().getPrice()));
                Payments payments = new Payments();
                payments.setClient(client.get());
                payments.setProducts(products.get());
                payments.setDate(LocalDate.now());
                paymentRepository.save(payments);
            }
        }
    }
}
