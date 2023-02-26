package ru.geekbrains.winter.market.core.hw6_identity_map;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.geekbrains.winter.market.core.entities.Product;


@Component
@Slf4j
public class ProductFinder {
    private final IdentityMap identityMap = new IdentityMap();


    public boolean isProductPresentInMapById(Long id) {
        log.info("isProductPresentInMapById({})" + " - "+ identityMap.isPresent(id), id);
        return identityMap.isPresent(id);
    }

    public void putNewTmpProductInMap(Product product) {
        log.info("putNewTmpProductInMap");
        identityMap.addProduct(product);
    }

    public Product findProductInMapById(Long id) {
        log.info("findProductInMapById");
        return identityMap.getProduct(id);

    }
}
