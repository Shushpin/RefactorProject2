public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Order order1 = new OrderBuilder()
                .withCustomerType("regular")
                .withMembership(true)
                .addItem(new Item("Apple", 1.0, 3))
                .addItem(new Item("Banana", 2.0, 2))
                .build();
        store.addOrder(order1);

        Order order2 = new OrderBuilder()
                .withCustomerType("vip")
                .withCoupon(true)
                .addItem(new Item("Orange", 3.0, 1))
                .addItem(new Item("Grapes", 4.0, 1))
                .build();
        store.addOrder(order2);

        Order order3 = new OrderBuilder()
                .withCustomerType("new")
                .addItem(new Item("Mango", 5.0, 3))
                .addItem(new Item("Peach", 3.0, 4))
                .build();
        store.addOrder(order3);

        store.printAllOrders();
    }
}
