package Module3.strategy;

public class CardPayment implements PaymentStrategy{
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплата картой " + cardNumber + ": на сумму " + amount + "₽");
    }
}
