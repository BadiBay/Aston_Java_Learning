package Module3.decorator;

public class GiftWrapDecorator extends OrderPriceDecorator{
    public GiftWrapDecorator(OrderPrice wrapped) {
        super(wrapped);
    }

    @Override
    public int getPrice() {
        return wrapped.getPrice() + 300;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + подарочная упаковка";
    }
}
