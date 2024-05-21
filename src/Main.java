<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Order {
    List<Item> items = new ArrayList<>();
    String customerType;
    boolean hasMembership;
    boolean hasCoupon;

    Order(String customerType, boolean hasMembership, boolean hasCoupon) {
        this.customerType = customerType;
        this.hasMembership = hasMembership;
        this.hasCoupon = hasCoupon;
    }

    void addItem(Item item) {
        items.add(item);
    }

    double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.price * item.quantity;
        }
        if (customerType.equals("regular")) {
            total = total * 0.95;
        } else if (customerType.equals("vip")) {
            total = total * 0.90;
        } else if (customerType.equals("new")) {
            total = total * 1.0;
        }

        if (hasMembership) {
            total = total * 0.98;
        }

        if (hasCoupon) {
            total = total - 5;
        }

        return total;
    }
}

class Store {
    List<Order> orders = new ArrayList<>();

    void addOrder(Order order) {
        orders.add(order);
    }

    void printAllOrders() {
        for (Order order : orders) {
            System.out.println("Order for customer type: " + order.customerType);
            System.out.println("Items:");
            for (Item item : order.items) {
                System.out.println("- " + item.name + ": " + item.quantity + " x $" + item.price);
            }
            System.out.println("Total: " + order.calculateTotal());
            System.out.println("-------------");
        }
    }
}

>>>>>>> c3674246d4f7979e00b72236735f5535ecff8072
public class Main {
    public static void main(String[] args) {
        Store store = new Store();

<<<<<<< HEAD
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
=======
        Order order1 = new Order("regular", true, false);
        order1.addItem(new Item("Apple", 1.0, 3));
        order1.addItem(new Item("Banana", 2.0, 2));
        store.addOrder(order1);

        Order order2 = new Order("vip", false, true);
        order2.addItem(new Item("Orange", 3.0, 1));
        order2.addItem(new Item("Grapes", 4.0, 1));
        store.addOrder(order2);

        Order order3 = new Order("new", false, false);
        order3.addItem(new Item("Mango", 5.0, 2));
        order3.addItem(new Item("Peach", 3.0, 4));
>>>>>>> c3674246d4f7979e00b72236735f5535ecff8072
        store.addOrder(order3);

        store.printAllOrders();
    }
}
