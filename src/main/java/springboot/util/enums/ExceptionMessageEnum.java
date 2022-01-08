package springboot.util.enums;

public enum ExceptionMessageEnum {

    INCORRECT_REQUEST_EMPTY_ITEMS_ORDER("Pedido no tien detalle");

    private String value;

    ExceptionMessageEnum(String message) {
        this.value = message;
    }

    public String getValue() {
        return value;
    }

}
