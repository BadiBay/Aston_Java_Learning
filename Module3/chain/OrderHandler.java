package Module3.chain;

import Module3.builder.Order;

public interface OrderHandler {
    OrderHandler setNext(OrderHandler next);
    boolean handle(Order order);
}
