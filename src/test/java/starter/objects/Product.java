package starter.objects;

public class Product {
    private String namePrdInCart;
    private String pricePrdInCart;
    private String quantity;
    private String description;

    public Product(String namePrdInCart, String pricePrdInCart, String quantity, String description) {
        this.namePrdInCart = namePrdInCart;
        this.pricePrdInCart = pricePrdInCart;
        this.quantity = quantity;
        this.description = description;
    }

    public Product() {
    }
//
//    public Product(String namePrdInCart, String pricePrdInCart, String quantity) {
//        this.namePrdInCart = namePrdInCart;
//        this.pricePrdInCart = pricePrdInCart;
//        this.quantity = quantity;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "namePrdInCart='" + namePrdInCart + '\'' +
                ", pricePrdInCart='" + pricePrdInCart + '\'' +
                ", quantity='" + quantity + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getNamePrdInCart() {
        return namePrdInCart;
    }

    public void setNamePrdInCart(String namePrdInCart) {
        this.namePrdInCart = namePrdInCart;
    }

    public String getPricePrdInCart() {
        return pricePrdInCart;
    }

    public void setPricePrdInCart(String pricePrdInCart) {
        this.pricePrdInCart = pricePrdInCart;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//
//    public String getNamePrdInCart() {
//        return namePrdInCart;
//    }
//
//    public void setNamePrdInCart(String namePrdInCart) {
//        this.namePrdInCart = namePrdInCart;
//    }
//
//    public String getPricePrdInCart() {
//        return pricePrdInCart;
//    }
//
//    public void setPricePrdInCart(String pricePrdInCart) {
//        this.pricePrdInCart = pricePrdInCart;
//    }
//
//    public String getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(String quantity) {
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString() {
//        return namePrdInCart + " ___ " + pricePrdInCart + " ___ " + quantity + "\n";
//    }
}
