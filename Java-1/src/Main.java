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

    public static boolean isProductIdExistInInvoice(int productId, Map<Integer, Invoice> invoices) {
        for (Map.Entry<Integer, Invoice> entry : invoices.entrySet()) {
            Integer invoiceId = entry.getKey();
            if (invoiceId.equals(productId)) {
                return false;
            }
        }
        return true;
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
        Sell sell = new Sell();
        Map<Integer, Invoice> invoices = new HashMap();
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

                        if (isProductIdExistInInvoice(productId, invoices)) {

                            for (Product product : products) {

                                if (product.getProId() == productId) {

                                    System.out.print("Enter QTY : ");
                                    int qty = scanner.nextInt();

                                    if (isQtyUnderStockQty(productId, products, qty)) {

                                        System.out.print("Enter Discount: ");
                                        Float discount = scanner.nextFloat();
                                        sell = new Sell(product, qty, discount);
                                        invoices.put(product.getProId(), new Invoice(idAutoIncrement, product, sell, qty * product.getPrice()));
                                    }
                                    idAutoIncrement++;
                                }
                            }
                        } else {
                            System.out.println("Product id is already in cart. Please try again!");
                        }

                    } else {
                        System.out.println("Product id is not exits. Please try again!");
                    }

                }
                break;
                case 2: {
                    System.out.println("===== Invoice =====");
                    for (Map.Entry<Integer, Invoice> entry : invoices.entrySet()) {
                        Integer invoiceId = entry.getKey();
                        Invoice invoice = entry.getValue();
                        System.out.println("Invoice ID: " + invoiceId);
                        System.out.println("Product ID: " + invoice.getProduct().getProId());
                        System.out.println("Product Name: " + invoice.getProduct().getName());
                        System.out.println("Product Price: " + invoice.getProduct().getPrice());
                        System.out.println("Discount: " + invoice.getSell().getDiscount());
                        System.out.println("Total: " + invoice.getTotal());
                        System.out.println("-------------------------");
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