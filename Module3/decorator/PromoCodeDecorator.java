package Module3.decorator;

public class PromoCodeDecorator extends OrderPriceDecorator{
    public PromoCodeDecorator(OrderPrice wrapped) {
        super(wrapped);
    }

    @Override
    public int getPrice() {
        int price = wrapped.getPrice();
        return price - price*10/100;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " - 10% по промокоду";
    }
}
