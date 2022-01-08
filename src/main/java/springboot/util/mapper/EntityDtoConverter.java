package springboot.util.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.dto.OrderResponse;
import springboot.model.Order;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public OrderResponse convertEntitytoDto(Order order) {
        return modelMapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> convertEntitytoDto(List<Order> orders) {
        return orders.stream()
                .map(order->convertEntitytoDto(order))
                .collect(Collectors.toList());
    }
}
