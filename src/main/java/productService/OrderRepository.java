package productService;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderRecord, Long> {

    @Query(value="SELECT new productService.OrderSummary(o.productId,sum(o.quantity),sum(o.orderValue)) from OrderRecord o GROUP BY o.productId")
    public Iterable<OrderSummary> getOrderSummaries();

    @Query(value="SELECT new productService.ProductOrderSummary(p.name,sum(o.quantity),sum(o.orderValue)) from OrderRecord o, Product p WHERE p.id = ?1 AND p.id = o.productId")
    public ProductOrderSummary getProductOrderSummary(Long id);
}
