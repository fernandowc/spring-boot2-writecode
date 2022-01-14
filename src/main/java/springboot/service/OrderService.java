package springboot.service;

import springboot.dto.OrderRequest;
import springboot.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> listarOrder();
    Order createOrder(OrderRequest order);
    Order buscarOrderPorId(String orderId);
    List<Order> buscarOrdersPorAccountId(String accountId);

}
