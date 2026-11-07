package Module3.chain;

import Module3.builder.Order;

public class AddressCheckHandler extends AbstractOrderHandler{

    @Override
    public boolean handle(Order order) {
        String address = order.getAddress();
        if (address == null || address.isEmpty()){
            System.out.println("Ошибка: адрес доставки не указан - отказ");
            return false;
        }
        System.out.println("Адрес указан - продолжаем проверку");
        return passToNext(order);
    }
}
