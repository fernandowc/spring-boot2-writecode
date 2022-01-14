package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springboot.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    //Named Querys
    @Query("SELECT order FROM Order order WHERE order.accountId=?1")
    List<Order> listarPedidosPorCuentaJPQL(String accountId);

    //Native Querys
    @Query(value = "SELECT * FROM orders o WHERE o.account_id=?1", nativeQuery = true)
    List<Order> listarPedidosPorCuentaSQL(String accountId);

    Order findByOrderId(String orderId);
    List<Order> findOrderByAccountId(String accountId);

}
