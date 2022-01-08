package springboot.util;

import springboot.dto.OrderRequest;
import springboot.exception.IncorrectOrderRequestException;
import springboot.util.enums.ExceptionMessageEnum;

public class OrderValidator {

    public static boolean validateOrder(OrderRequest order) {
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IncorrectOrderRequestException(ExceptionMessageEnum
                    .INCORRECT_REQUEST_EMPTY_ITEMS_ORDER.getValue());
        }
        return true;
    }
}
