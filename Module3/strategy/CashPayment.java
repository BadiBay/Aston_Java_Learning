package Module3.strategy;

public class CashPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Оплата наличными, к оплате: " + amount + "₽");
    }
}
