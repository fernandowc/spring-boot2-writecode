package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dto.OrderRequest;
import springboot.exception.OrderNotFoundException;
import springboot.model.Order;
import springboot.model.OrderDetail;
import springboot.repository.OrderRepository;
import springboot.service.OrderService;
import springboot.util.Constant;
import springboot.util.OrderValidator;
import springboot.util.enums.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> listarOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        OrderValidator.validateOrder(orderRequest);
        Order newOrder= initOrder(orderRequest);

        return orderRepository.save(newOrder);
    }

    @Override
    public Order buscarOrderPorId(String orderId) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findByOrderId(orderId));
        return order.orElseThrow(() -> new OrderNotFoundException("OrderId no encontrado"));
    }

    @Override
    public List<Order> buscarOrdersPorAccountId(String accountId) {
        Optional<List<Order>> order = Optional.ofNullable(orderRepository.findOrderByAccountId(accountId));
        return order.orElseThrow(() -> new OrderNotFoundException("AccountId no encontrado"));
    }

    private Order initOrder(OrderRequest orderRequest) {
        Order orderObj = new Order();
        orderObj.setOrderId(UUID.randomUUID().toString());
        orderObj.setAccountId(orderRequest.getAccountId());
        orderObj.setStatus(OrderStatus.PENDING);

        List<OrderDetail> items = orderRequest.getItems().stream()
                .map(item -> OrderDetail.builder()
                        .price(item.getPrice())
                        .quantity(item.getQuantity())
                        .upc(item.getUpc())
                        .tax((item.getPrice() * item.getQuantity()) * Constant.TAX_IMPORT)
                        .totalAmount((item.getPrice() * item.getQuantity()))
                        .order(orderObj).build())
                .collect(Collectors.toList());

        orderObj.setItems(items);
        orderObj.setTotalAmount(items.stream().mapToDouble(OrderDetail::getTotalAmount).sum());
        orderObj.setTotalTax(orderObj.getTotalAmount() * Constant.TAX_IMPORT);
        orderObj.setTotalAmountTax(orderObj.getTotalAmount()+orderObj.getTotalTax());
        orderObj.setTransactionDate(new Date());
        return orderObj;
    }
}
