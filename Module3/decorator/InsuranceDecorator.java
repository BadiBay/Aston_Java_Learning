package Module3.decorator;

public class InsuranceDecorator extends OrderPriceDecorator{
    public InsuranceDecorator(OrderPrice wrapped) {
        super(wrapped);
    }

    @Override
    public int getPrice() {
        int price = wrapped.getPrice();
        return price + price*5/100;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + страховка груза (+5% от суммы заказа)";
    }
}
