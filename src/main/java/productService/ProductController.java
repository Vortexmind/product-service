package productService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path="/add")
    public @ResponseBody Product addNewProduct (@RequestParam String name, @RequestParam long price, @RequestParam long quantity){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setQuantity(quantity);
        productRepository.save(p);
        return p;

    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product")
    public @ResponseBody Product getSingleProductById (@RequestParam Long id){
        return productRepository.findOne(id);
    }

    @PutMapping("/buy")
    public @ResponseBody Product buyProductById (@RequestParam long id, @RequestParam long quantity) {
        Product p = productRepository.findOne(id);
        // Not good for concurrency ..
        if (p.getQuantity()-quantity >= 0) {
            p.setQuantity(p.getQuantity()-quantity);
            productRepository.save(p);

            OrderRecord o = new OrderRecord();
            o.setOrderDate(System.currentTimeMillis());
            o.setProductId(id);
            o.setQuantity(quantity);
            o.setOrderValue(quantity*p.getPrice());

            orderRepository.save(o);

            return p;
        }
        return null;
    }

    @PutMapping("/update")
    public @ResponseBody Product updateProductById(@RequestParam long id, @RequestParam String name, @RequestParam long price, @RequestParam long quantity){
        Product p = productRepository.findOne(id);

        p.setName(name);
        p.setPrice(price);
        p.setQuantity(quantity);

        productRepository.save(p);

        return p;
    }

    @GetMapping("/orders/summaries")
    public @ResponseBody Iterable<OrderSummary> getOrderSummaries(){
        return orderRepository.getOrderSummaries();
    }

    @GetMapping("/orders/summary")
    public @ResponseBody ProductOrderSummary getProductOrderSummary(@RequestParam long id){
        return orderRepository.getProductOrderSummary(id);
    }
}
