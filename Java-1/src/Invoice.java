public class Invoice {
    private Integer id;
    private Product product;
    private Sell sell;
    private Double total;

    public Invoice(Integer id, Product product, Sell sell, Double total) {
        this.id = id;
        this.product = product;
        this.sell = sell;
        this.total = total;
    }

    public Invoice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
