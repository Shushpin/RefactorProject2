import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();
    private String customerType;
    private boolean hasMembership;
    private boolean hasCoupon;
    double total;

    Order(String customerType, boolean hasMembership, boolean hasCoupon, List<Item> items) {
        this.customerType = customerType;
        this.hasMembership = hasMembership;
        this.hasCoupon = hasCoupon;
        this.items = items;
        this.total = calculateItemsTotal();
        applyDiscount();
    }

    double calculateItemsTotal() {
        return items.stream()
                .mapToDouble(Item::calculateTotalPrice)
                .sum();
    }

    void applyDiscount() {
        total = DiscountManager.applyCustomerTypeDiscount(this);
        DiscountManager.applyMembershipDiscount(this);
        DiscountManager.applyCouponDiscount(this);
    }

    void addItem(Item item) {
        items.add(item);
        total = calculateItemsTotal();
        applyDiscount();
    }

    double getTotal() {
        return total;
    }

    String getCustomerType() {
        return customerType;
    }

    boolean hasMembership() {
        return hasMembership;
    }

    boolean hasCoupon() {
        return hasCoupon;
    }

    List<Item> getItems() {
        return items;
    }
}
