abstract class Discount {
    abstract double applyDiscount(double total);
}

class RegularCustomerDiscount extends Discount {
    double applyDiscount(double total) {
        return total * 0.95;
    }
}

class VIPCustomerDiscount extends Discount {
    double applyDiscount(double total) {
        return total * 0.90;
    }
}

class NewCustomerDiscount extends Discount {
    double applyDiscount(double total) {
        return total;
    }
}

public class CustomerTypeDiscount {
    static double applyDiscount(Order order) {
        Discount discount;
        switch (order.getCustomerType()) {
            case "regular":
                discount = new RegularCustomerDiscount();
                break;
            case "vip":
                discount = new VIPCustomerDiscount();
                break;
            case "new":
            default:
                discount = new NewCustomerDiscount();
                break;
        }
        return discount.applyDiscount(order.total);
    }
}
