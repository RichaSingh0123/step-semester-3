public class Main {
    public static void main(String[] args) {
        Order x = new Order("X", new Customer("Customer X"));
        x.addProduct(new Product("Product A", 100), 2);
        x.addProduct(new Product("Product B", 50), 1);
        System.out.println("Order created for Customer X.");
        x.pay(new CreditCardPayment());

        Order y = new Order("Y", new Customer("Customer Y"));
        y.pay(new CreditCardPayment());

        Order z = new Order("Z", new Customer("Customer Z"));
        z.addProduct(new Product("Product C", 75), 1);
        System.out.println("Order created for Customer Z.");
        z.pay(new PayPalPayment());
    }
}
