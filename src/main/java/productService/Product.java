package productService;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private long price;
    private long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public long getPrice() { return price; }

    public void setPrice(long price) { this.price = price; }

    public long getQuantity() {
      return quantity;
    }

    public void setQuantity( long quantity) { this.quantity = quantity; }
}
