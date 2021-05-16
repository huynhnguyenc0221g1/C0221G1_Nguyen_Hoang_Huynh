package ss11_map_tree.bai_tap.luyen_tap_arraylist_linkedlist.linkedlist;

public class Product implements Comparable<Product>{
    private String name;
    private int id;
    private int price;

    public Product() {
    }

    public Product(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return '\n' + "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                '}' + '\n';
    }

    @Override
    public int compareTo(Product o) {
        return toString().compareTo(o.toString());
    }
}
