package Module3.strategy;

public class PaymentProcessor {
    public PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }
    public void pay(int amount){
        strategy.pay(amount);
    }
}
