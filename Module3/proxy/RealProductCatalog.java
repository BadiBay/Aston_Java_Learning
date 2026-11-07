package Module3.proxy;

import Module3.proxy.Product;

import java.util.HashMap;
import java.util.Map;

public class RealProductCatalog implements ProductCatalog{
    Map<Integer, Product> database = new HashMap<>();

    public RealProductCatalog() {
        database.put(1, new Product(1,"Ноутбук",70000));
        database.put(2, new Product(2,"Мышь",5000));
        database.put(3, new Product(3,"Клавиатура",7000));
        database.put(4, new Product(4,"Флешка",500));
    }

    @Override
    public Product findById(int id) {
        System.out.println("Запрос товара из БД по id="+id);
        return database.get(id);
    }
}
