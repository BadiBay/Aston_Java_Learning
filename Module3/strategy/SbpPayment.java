package Module3.strategy;

public class SbpPayment implements PaymentStrategy{
    private final String phoneNumber;

    public SbpPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Оплата по СБП по номеру телефона:" + phoneNumber + ", на сумму " + amount + "₽");
    }
}

