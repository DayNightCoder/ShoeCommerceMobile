package com.example.sachinpc.restshoecommerce;

/**
 * Created by SachinPC on 3/6/2018.
 */


        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import java.io.Serializable;

public class Cart implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    int cart_id;

    //int cart_user_id; //, cart_pro_id;

   @SerializedName("cart_pro_id")
   @Expose
   int cart_pro_id;

   Product product;

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    @SerializedName("cart_user_id")
    @Expose
   int cart_user_id;

    User user;


    /**
     * @return the checkout
     */
    public Checkout getCheckout() {
        return checkout;
    }

    /**
     * @param checkout the checkout to set
     */
    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

   @SerializedName("checkout_id")
   @Expose
   int checkout_id;



    Checkout checkout;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    public int getCheckout_id() {
        return checkout_id;
    }

    public void setCheckout_id(int checkout_id) {
        this.checkout_id = checkout_id;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart() {
        super();
    }

    public Cart(int cart_user_id, int cart_pro_id, int cart_quantity, int cart_size) {
        super();
        this.cart_user_id = cart_user_id;
        this.cart_pro_id = cart_pro_id;
        this.cart_quantity = cart_quantity;
        this.cart_size = cart_size;
    }

    @SerializedName("cart_quantity")
    @Expose
    int cart_quantity;

    @SerializedName("cart_size")
    @Expose
    int cart_size;

    public Cart(int cart_id, int cart_user_id, int cart_pro_id, int cart_quantity, int cart_size) {
        super();
        this.cart_id = cart_id;
        this.cart_user_id = cart_user_id;
        this.cart_pro_id = cart_pro_id;
        this.cart_quantity = cart_quantity;
        this.cart_size = cart_size;
    }

    /**
     * @return the cart_id
     */
    public int getCart_id() {
        return cart_id;
    }

    /**
     * @param cart_id the cart_id to set
     */
    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    /**
     * @return the cart_user_id
     */
    public int getCart_user_id() {
        return cart_user_id;
    }

    /**
     * @param cart_user_id the cart_user_id to set
     */
    public void setCart_user_id(int cart_user_id) {
        this.cart_user_id = cart_user_id;
    }

    /**
     * @return the cart_pro_id
     */
    public int getCart_pro_id() {
        return cart_pro_id;
    }

    /**
     * @param cart_pro_id the cart_pro_id to set
     */
    public void setCart_pro_id(int cart_pro_id) {
        this.cart_pro_id = cart_pro_id;
    }

    /**
     * @return the cart_quanitity
     */
    public int getCart_quantity() {
        return cart_quantity;
    }

    /**
     * @param cart_quantity the cart_quantity to set
     */
    public void setCart_quantity(int cart_quantity) {
        this.cart_quantity = cart_quantity;
    }

    /**
     * @return the cart_size
     */
    public int getCart_size() {
        return cart_size;
    }

    /**
     * @param cart_size the cart_size to set
     */
    public void setCart_size(int cart_size) {
        this.cart_size = cart_size;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", cart_pro_id=" + cart_pro_id +
                ", product=" + product +
                ", cart_user_id=" + cart_user_id +
                ", user=" + user +
                ", checkout_id=" + checkout_id +
                ", checkout=" + checkout +
                ", cart_quantity=" + cart_quantity +
                ", cart_size=" + cart_size +
                '}';
    }
}
