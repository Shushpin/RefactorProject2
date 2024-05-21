import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private String customerType;
    private boolean hasMembership;
    private boolean hasCoupon;
    private List<Item> items = new ArrayList<>();

    OrderBuilder withCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    OrderBuilder withMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
        return this;
    }

    OrderBuilder withCoupon(boolean hasCoupon) {
        this.hasCoupon = hasCoupon;
        return this;
    }

    OrderBuilder addItem(Item item) {
        items.add(item);
        return this;
    }

    Order build() {
        return new Order(customerType, hasMembership, hasCoupon, items);
    }
}
