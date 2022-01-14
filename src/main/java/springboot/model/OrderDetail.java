package springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddetail;

    private Integer quantity;

    private Double price;

    private Double tax;

    private String upc;

    @Column(name = "total_amount")
    private Double totalAmount;

    @ManyToOne
    private Order order;
}
