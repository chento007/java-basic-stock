public class Product {
    private Integer proId;
    private String name;
    private Double price;
    private Double cost;
    private Integer stockQty;

    public Product(Integer proId, String name, Double price, Double cost, Integer stockQty) {
        this.proId = proId;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.stockQty = stockQty;
    }

    public Product() {

    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }
}
