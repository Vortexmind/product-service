package productService;

public class ProductOrderSummary {

    private String productName;
    private Long totalQuantity;
    private Long totalAmount;

    public ProductOrderSummary(String productName, Long totalQuantity, Long totalAmount){
        this.productName = productName;
        this.totalQuantity = totalQuantity;
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
}
