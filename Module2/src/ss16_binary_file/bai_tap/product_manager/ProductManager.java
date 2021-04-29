package ss16_binary_file.bai_tap.product_manager;

import java.util.*;

public class ProductManager {
    static Scanner input = new Scanner(System.in);
    static List<Product> productList = new ArrayList<>();

    public static void addProduct() {
        System.out.print("Please input product's id: ");
        int productCode = Integer.parseInt(input.nextLine());
        System.out.print("Please input product's name: ");
        String productName = input.nextLine();
        System.out.print("Please input product's manufacturer: ");
        String producer = input.nextLine();
        System.out.print("Please input product's price: ");
        float price = Float.parseFloat(input.nextLine());
        System.out.print("Please input product's other information: ");
        String description = input.nextLine();
        Product product = new Product(productCode, productName, producer, price, description);
        productList.add(product);

        IOFile.writeToFile("src/ss16_binary_file/bai_tap/product_manager/product.csv", productList);
    }

    public static void search() {
        System.out.print("Please input a product name: ");
        String name = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals(name)) {
                System.out.println(productList.get(i).toString());
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Not found!");
        }
    }

    public static void showProduct() {
        List<Product>list=IOFile.readDataFromFile("src/ss16_binary_file/bai_tap/product_manager/product.csv");
        for (Product pr:list){
            System.out.println(pr);
        }
    }

    public static void priceComparator() {
        List<Product>list=IOFile.readDataFromFile("src/ss16_binary_file/bai_tap/product_manager/product.csv");
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                }else if(o1.getPrice()==o2.getPrice()){
                    return 0;
                }else
                    return -1;
            }
        });
        System.out.println("Ascending order!");
        for (Product pr:list){
            System.out.println(pr.toString());
        }
        IOFile.writeToFile("src/ss16_binary_file/bai_tap/product_manager/product.csv",list);
    }
}
