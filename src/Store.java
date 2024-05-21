import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Order> orders = new ArrayList<>();

    void addOrder(Order order) {
        orders.add(order);
    }

    void printAllOrders() {
        for (Order order : orders) {
            System.out.println("Order for customer type: " + order.getCustomerType());
            System.out.println("Items:");
            for (Item item : order.getItems()) {
                System.out.println("- " + item.getName() + ": " + item.getQuantity() + " x $" + item.getPrice());
            }
            System.out.println("Total: " + order.getTotal());
            System.out.println("-------------");
        }
    }
}
