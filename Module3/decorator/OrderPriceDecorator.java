package Module3.decorator;

import Module3.builder.Order;

public abstract class OrderPriceDecorator implements OrderPrice{
    protected final OrderPrice wrapped;

    protected OrderPriceDecorator(OrderPrice wrapped) {
        this.wrapped = wrapped;
    }
}
