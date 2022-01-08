package springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class OrderRequest {
    private String accountId;
    private List<LineItem> items;
}
