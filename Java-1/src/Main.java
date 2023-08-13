import java.util.*;

public class Main {

    public static void showProduct(List<Product> products) {
        System.out.println("===================================================================");
        for (Product product : products) {
            System.out.println("ID: " + product.getProId() + " Name: " + product.getName() + " Price: " + product.getPrice() + " Cost: " + product.getCost() + " StockQty: " + product.getStockQty());
        }
        System.out.println("===================================================================");
    }

    public static boolean isProductExist(int productId, List<Product> products) {
        return products.stream().anyMatch(product -> product.getProId() == productId);
    }

    public static boolean isQtyUnderStockQty(Integer productId, List<Product> products, int qty) {
        return products.stream().anyMatch(product -> product.getProId().equals(productId) && qty <= product.getStockQty());
    }

    public static void main(String[] args) {
        // Set default value for product
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>(
                List.of(
                        new Product(1, "Coca", 20.0, 10.0, 10),
                        new Product(2, "Fanta", 20.0, 10.0, 10),
                        new Product(3, "Sting", 20.0, 10.0, 10),
                        new Product(4, "Coffee", 20.0, 10.0, 10),
                        new Product(4, "Jinro", 20.0, 10.0, 10),
                        new Product(5, "ABC", 20.0, 10.0, 10)
                )
        );
        // Instance object for sale
        Map<Integer, Sell> sells = new HashMap<>();
        ArrayList<Invoice> invoices = new ArrayList<>();
        int idAutoIncrement = 1;
        // Create system to sell product
        do {
            System.out.println("1. Buy");
            System.out.println("2. View Invoice");
            System.out.println("3. Exit");
            System.out.print("Please choose one option : ");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1: {

                    showProduct(products);

                    System.out.print("Please choose product Id : ");
                    int productId = scanner.nextInt();

                    if (isProductExist(productId, products)) {

                        for (Product product : products) {

                            if (product.getProId() == productId) {

                                System.out.print("Enter QTY : ");
                                int qty = scanner.nextInt();

                                if (isQtyUnderStockQty(productId, products, qty)) {

                                    System.out.print("Enter Discount: ");
                                    Float discount = scanner.nextFloat();
                                    sells.put(productId, new Sell(product, qty, discount));
                                    invoices.add(new Invoice(idAutoIncrement, product, sells.get(productId), qty * product.getPrice()));
                                }
                                idAutoIncrement++;
                            }
                        }
                    } else {
                        System.out.println("Product id is not exits. Please try again!");
                    }

                }
                break;
                case 2: {
                    System.out.println("===== Invoice =====");
                    System.out.println("ID      ProductId       ProductName     Product Price       Discount        Total");
                    for (Invoice invoice : invoices) {
                        System.out.println("Id: "+invoice.getId() + " ProductId: "  + invoice.getProduct().getProId() + " ProductName: "
                                + invoice.getProduct().getName() + " ProductPrice: " + invoice.getProduct().getPrice() + " Discount: "
                                + invoice.getSell().getDiscount() + " Total: " + invoice.getTotal());
                    }
                }
                break;
                case 3: {
                    System.exit(0);
                }
                break;
            }

        } while (true);
    }
}