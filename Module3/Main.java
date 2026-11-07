package Module3;

import Module3.adapter.EmailSender;
import Module3.adapter.NotificationSender;
import Module3.adapter.SmsAdapter;
import Module3.adapter.ThirdPartySmsApi;
import Module3.builder.Order;
import Module3.chain.AddressCheckHandler;
import Module3.chain.AmountLimitHandler;
import Module3.chain.ItemsCheckHandler;
import Module3.chain.OrderHandler;
import Module3.decorator.*;
import Module3.proxy.CachingProductCatalogProxy;
import Module3.proxy.Product;
import Module3.proxy.ProductCatalog;
import Module3.proxy.RealProductCatalog;
import Module3.strategy.CardPayment;
import Module3.strategy.CashPayment;
import Module3.strategy.PaymentProcessor;
import Module3.strategy.SbpPayment;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        System.out.println("--Proxy--");
        ProductCatalog catalog = new CachingProductCatalogProxy(new RealProductCatalog());
        Product laptop = catalog.findById(1);
        Product mouse = catalog.findById(2);
        Product flash = catalog.findById(4);
        catalog.findById(1);
        System.out.println();

        System.out.println("--Builder--");
        Order order = new Order.Builder(1001,"Дмитрий")
                .email("dmitry@lapshin.com")
                .address("Киров, Московская 36")
                .phone("+79125848235")
                .addItem(laptop.getName(),laptop.getPrice())
                .addItem(mouse.getName(), mouse.getPrice())
                .build();
        System.out.println(order);
        System.out.println("----------------");

        Order noAddress = new Order.Builder(1002,"Анна")
                .email("anna@anna.com")
                .addItem(mouse.getName(), mouse.getPrice())
                .build();
        System.out.println(noAddress);
        System.out.println("----------------");
        Order lessMin = new Order.Builder(1003,"Михаил")
                .address("Казань, ул. Баумана, 5")
                .addItem(flash.getName(), flash.getPrice())
                .build();
        System.out.println(lessMin);
        System.out.println("----------------");
        System.out.println();

        System.out.println("--Chain--");
        OrderHandler orderHandler = new ItemsCheckHandler();
        orderHandler.setNext(new AddressCheckHandler()).setNext(new AmountLimitHandler());
        for (Order o : Arrays.asList(order,noAddress,lessMin)){
            System.out.println("Проверка заказа №" + o.getId()+": ");
            boolean ok = orderHandler.handle(o);
            System.out.println("Результат: " + (ok ? "Принят" : "Отклонен"));
            System.out.println("----------------");
        }
        System.out.println();

        System.out.println("--Decorator--");
        OrderPrice price = new BaseOrderPrice(order);
        print(price);

        price = new GiftWrapDecorator(price);
        print(price);

        price = new InsuranceDecorator(price);
        print(price);

        price = new PromoCodeDecorator(price);
        print(price);

        int finalPrice = price.getPrice();
        System.out.println();

        System.out.println("--Strategy--");
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.setStrategy(new CardPayment("1234-5678-9123-4567"));
        paymentProcessor.pay(finalPrice);

        paymentProcessor.setStrategy(new CashPayment());
        paymentProcessor.pay(finalPrice);

        paymentProcessor.setStrategy(new SbpPayment("+79842648452"));
        paymentProcessor.pay(finalPrice);
        System.out.println();

        System.out.println("--Adapter--");
        NotificationSender email = new EmailSender();
        NotificationSender sms = new SmsAdapter(new ThirdPartySmsApi());

        String message = "Заказ №" + order.getId() + " оплачен, сумма " + finalPrice + "₽";
        email.send(order.getEmail(), message);
        sms.send(order.getPhone(), message);


    }
    private static void print(OrderPrice price) {
        System.out.println(price.getDescription() + " = " + price.getPrice() + "₽");
    }
}