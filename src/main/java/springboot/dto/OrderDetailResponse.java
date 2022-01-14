package springboot.dto;

import lombok.Getter;
import lombok.Setter;
import springboot.model.Order;

import javax.persistence.*;

@Getter
@Setter
public class OrderDetailResponse {

    private Long iddetail;

    private Integer quantity;

    private Double price;

    private Double tax;

    private String upc;

    private Double totalAmount;
}
