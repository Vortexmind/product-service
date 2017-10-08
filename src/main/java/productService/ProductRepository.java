package productService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import productService.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
