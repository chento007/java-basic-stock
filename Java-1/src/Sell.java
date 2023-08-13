import java.util.Set;

public class Sell {
    private Product product;
    private Integer qty;
    private Float discount;

    public Sell(Product product, Integer qty, Float discount) {
        this.product = product;
        this.qty = qty;
        this.discount = discount;
    }

    public Sell() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
