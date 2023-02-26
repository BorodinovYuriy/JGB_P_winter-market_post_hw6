package ru.geekbrains.winter.market.core.hw6_identity_map;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.winter.market.core.entities.Product;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
public class IdentityMap {

    private Map<Long, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        } else {
            log.info("Key already in Map");
        }
    }

    public Product getProduct(Long id) {
        Product product = productMap.get(id);
        if (product == null) {
            log.info("ID not in Map.");
        }
        return product;
    }

    public boolean isPresent(Long id) {
        return productMap.get(id) != null;
    }
}
