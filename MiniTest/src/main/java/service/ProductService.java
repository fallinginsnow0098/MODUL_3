package service;

import model.Product;

import java.util.ArrayList;
public class ProductService {
    private static final ArrayList<Product> products;
    private static final ArrayList<Product> cartItems ;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "IPHONE", 1000, 10, "Smart phone"));
        products.add(new Product(2, "SAMSUNG", 899, 10, "Smart phone"));
        products.add(new Product(3, "OPPO", 599, 10, "Smart phone"));
        products.add(new Product(4, "XIAOMI", 699, 10, "Smart phone"));
        products.add(new Product(5, "BLACKBERRY", 799, 10, "Smart phone"));
        cartItems = new ArrayList<>();
    }
    public ArrayList<Product> getCartItems(){
        return cartItems;
    }
    public ArrayList<Product> getProducts(){
        return products;
    }
    public Product getProduct(int id){
        for (Product p : products) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public ArrayList<Product> sortByPriceUp(){
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return 0;
        });
        return products;
    }
    public ArrayList<Product> sortByPriceDown(){
        products.sort((o1, o2) -> {
            if (o1.getPrice() < o2.getPrice()) return 1;
            else if (o1.getPrice() > o2.getPrice()) return -1;
            else return 0;
        });
        return products;
    }
    public void addToCart(int id){
        for (Product p : products) {
            if (p.getId() == id){
                cartItems.add(p);
                p.setQuantity(p.getQuantity() + 1);
            }
        }
    }
    public void removeFromCart(int id){
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id){
                product = p;
            }
        }
        if (product != null){
            cartItems.remove(product);
        }
    }
    public double payForCart(){
        double total = 0;
        for (Product p : cartItems) {
            total += (p.getPrice() * p.getQuantity());
            cartItems.remove(p);
        }
        return total;
    }

}
