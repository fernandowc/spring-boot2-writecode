package springboot.service;

import org.springframework.stereotype.Service;
import springboot.dto.OrderRequest;
import springboot.dto.OrderResponse;
import springboot.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    public Order createOrder(OrderRequest orderRequest) {

        Order response = new Order();
        response.setAccountId(orderRequest.getAccountId());
        response.setOrderId("999999");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());
        return response;
    }

    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();

        Order response = new Order();
        response.setAccountId("999999");
        response.setOrderId("111123");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        Order response2 = new Order();
        response2.setAccountId("999991");
        response2.setOrderId("111124");
        response2.setStatus("PENDING");
        response2.setTotalAmount(150.00);
        response2.setTotalTax(19.00);
        response2.setTransactionDate(new Date());

        orders.add(response);
        orders.add(response2);

        return orders;
    }

    public Order findOrderById(String orderId) {
        Order response = new Order();
        response.setAccountId("999999");
        response.setOrderId(orderId);
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return response;
    }

}
