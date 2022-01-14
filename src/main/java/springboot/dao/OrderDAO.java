package springboot.dao;

import springboot.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {
    List<Order> findAll();
    Optional<Order> findByOrderId();
}
