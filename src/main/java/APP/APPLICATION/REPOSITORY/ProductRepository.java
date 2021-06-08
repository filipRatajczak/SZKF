package APP.APPLICATION.REPOSITORY;

import APP.APPLICATION.MODELS.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByProductName(String name);
}
