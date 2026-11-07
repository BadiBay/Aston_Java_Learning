package Module3.chain;

import Module3.builder.Order;

public class AmountLimitHandler extends AbstractOrderHandler{

    @Override
    public boolean handle(Order order) {
        int itemAmount = order.getItemsTotal();
        if (itemAmount < 1000){
            System.out.println("Сумма заказа меньше минимальной для бесплатной доставки, не хватает до бесплатной доставки " + (1000 - order.getItemsTotal()) + "₽");

            return false;
        }
        System.out.println("Сумма заказа больше или равна минимальной - бесплатная доставка");
        return passToNext(order);
    }
}
