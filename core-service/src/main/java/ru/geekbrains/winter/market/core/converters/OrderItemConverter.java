package ru.geekbrains.winter.market.core.converters;

import org.springframework.stereotype.Component;
import ru.geekbrains.winter.market.api.OrderItemDto;
import ru.geekbrains.winter.market.core.entities.OrderItem;

@Component
public class OrderItemConverter {
    public OrderItemDto entityToDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        orderItemDto.setProductTitle(orderItem.getProduct().getTitle());
        return orderItemDto;
    }
}
