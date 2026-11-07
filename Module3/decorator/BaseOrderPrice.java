package Module3.decorator;

import Module3.builder.Order;
import Module3.chain.OrderHandler;

public class BaseOrderPrice implements OrderPrice {
    private final Order order;

    public BaseOrderPrice(Order order) {
        this.order = order;
    }

    @Override
    public int getPrice() {
        return order.getItemsTotal();
    }

    @Override
    public String getDescription() {
        return "Товары";
    }
}
