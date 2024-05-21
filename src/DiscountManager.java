public class DiscountManager {
    static double applyCustomerTypeDiscount(Order order) {
        return CustomerTypeDiscount.applyDiscount(order);
    }

    static void applyMembershipDiscount(Order order) {
        if (order.hasMembership()) {
            order.total = order.total * 0.98;
        }
    }

    static void applyCouponDiscount(Order order) {
        if (order.hasCoupon()) {
            order.total = order.total - 5;
        }
    }
}
