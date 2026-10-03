package week7.assignment_problems;

public class Cart {

    private final double[] prices;
    private final String cartId;
    private int count;

    public Cart(String cartId, int capacity) {

        this.cartId = cartId;
        prices = new double[capacity];
        count = 0;
    }

    public void addItem(double price) {

        if (price < 0) {
            System.out.println("Invalid price");
            return;
        }

        if (count >= prices.length) {
            System.out.println("Cart is full");
            return;
        }

        prices[count] = price;
        count++;
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < count; i++) {

            total = total + prices[i];
        }

        return total;
    }

    public int getItemCount() {

        return count;
    }

    public static void main(String[] args) {

        Cart cart =
                new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(
                "Total: " + cart.getTotal()
        );

        System.out.println(
                "Item count: " +
                cart.getItemCount()
        );
    }
}