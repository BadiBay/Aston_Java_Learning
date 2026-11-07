package Module3.chain;

import Module3.builder.Order;

public abstract class AbstractOrderHandler implements OrderHandler{
    private OrderHandler next;
    @Override
    public OrderHandler setNext(OrderHandler next) {
        this.next = next;
        return next;
    }

    public boolean passToNext(Order order) {
        return next == null || next.handle(order);
    }
}
