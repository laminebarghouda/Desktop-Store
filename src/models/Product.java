package models;

public class Product {

    // Class variables
    public String productName;
    public double productPrice;
    public String productBrand;
    public String productCategory;
    private int productQuantityAvailable;
    public String productImage;

    /**
     * Product construct
     *
     * @param productName the name of the product
     * @param productPrice the price of the product
     * @param productBrand the brand of the product
     * @param productQuantityAvailable the quantity of the product
     */
    public Product(String productName, double productPrice, String productBrand, String productCategory, int productQuantityAvailable, String productImage){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.productCategory = productCategory;
        this.productQuantityAvailable = productQuantityAvailable;
        this.productImage = productImage;
    }


    /**
     * Returns the quantity available of the current product
     * @return int
     */
    public int getProductQuantityAvailable() {
        return productQuantityAvailable;
    }

    /**
     * controls and executes a purchase if the quantity required is available
     *
     * @param quantity required quantity of the purchase
     * @return true if successfully purchased, false otherwise
     */
    public boolean buyProduct(int quantity){
        if(this.productQuantityAvailable >= quantity) {
            this.productQuantityAvailable -= quantity;
            return true;
        }
        return false;
    }
}
