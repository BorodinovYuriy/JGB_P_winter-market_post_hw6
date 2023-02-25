package ru.geekbrains.winter.market.carts.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.geekbrains.winter.market.api.ProductDto;
import ru.geekbrains.winter.market.carts.integrations.ProductServiceIntegration;
import ru.geekbrains.winter.market.carts.model.Cart;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private final RedisTemplate<String, Object> redisTemplate;

    @Value("${cart-service.cart-prefix}")
    private String cartPrefix;

    public Cart getCurrentCart(String uuid) {
        String targetUuid = cartPrefix + uuid;
        if (!redisTemplate.hasKey(targetUuid)) {
            redisTemplate.opsForValue().set(targetUuid, new Cart());
        }
        return (Cart)redisTemplate.opsForValue().get(targetUuid);
    }

    public void add(String uuid, Long productId) {
        ProductDto product = productServiceIntegration.getProductById(productId);
        execute(uuid, cart -> cart.add(product));
    }

    public void remove(String uuid, Long productId) {
        execute(uuid, cart -> cart.remove(productId));
    }

    public void clear(String uuid) {
        execute(uuid, Cart::clear);
    }

    private void execute(String uuid, Consumer<Cart> operation) {
        Cart cart = getCurrentCart(uuid);
        operation.accept(cart);
        redisTemplate.opsForValue().set(cartPrefix + uuid, cart);
    }

    public void margeCarts(String uuid, String username) {
        Cart cartUuid = getCurrentCart(uuid);
        Cart cartUser = getCurrentCart(username);

        cartUuid.getItems().forEach(cartUser::addItem);
        cartUuid.clear();
        redisTemplate.opsForValue().set(cartPrefix + uuid, cartUuid);
        redisTemplate.opsForValue().set(cartPrefix + username, cartUser);

    }
}
