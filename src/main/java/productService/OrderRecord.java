package productService;

import org.hibernate.annotations.GenerationTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Long orderDate;
    private long quantity;
    private long orderValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id;}

    public Long getProductId() { return productId;}

    public void setProductId(long productId) { this.productId = productId; }

    public Long getOrderDate() { return orderDate; }

    public void setOrderDate(Long date) { this.orderDate = date; }

    public long getQuantity() {
      return quantity;
    }

    public void setQuantity( long quantity) { this.quantity = quantity; }

    public long getOrderValue() { return orderValue; }

    public void setOrderValue(long orderValue) {this.orderValue = orderValue; }
}
