package productService;

public class OrderSummary {

    private Long productId;
    private Long totalQuantity;
    private Long totalAmount;

    public OrderSummary(Long productId, Long totalQuantity, Long totalAmount){
        this.productId = productId;
        this.totalQuantity = totalQuantity;
        this.totalAmount = totalAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
