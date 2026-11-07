package Module3.proxy;


import java.util.HashMap;
import java.util.Map;

public class CachingProductCatalogProxy implements ProductCatalog{
    private final ProductCatalog real;
    private final Map<Integer,Product> cache = new HashMap<>();

    public CachingProductCatalogProxy(ProductCatalog real) {
        this.real = real;
    }

    @Override
    public Product findById(int id) {
        if (cache.containsKey(id)){
            System.out.println("Товар по id="+id+" отдан из кэша, это " + cache.get(id).getName());
            return cache.get(id);
        }
        Product product = real.findById(id);
        cache.put(id,product);
        return product;
    }
}
