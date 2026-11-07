package Module3.chain;

import Module3.builder.Order;

import java.util.List;

public class ItemsCheckHandler extends AbstractOrderHandler{

    @Override
    public boolean handle(Order order) {
        List<String> items = order.getItems();
        if (items.isEmpty()){
            System.out.println("В заказе должен быть хотя бы 1 товар - отказ");
            return false;
        }
        System.out.println("Товары есть в заказе");
        return passToNext(order);
    }
}
