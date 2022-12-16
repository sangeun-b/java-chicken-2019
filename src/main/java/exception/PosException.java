package exception;

import domain.Order;

import java.util.List;
import java.util.Map;

public class PosException {
    public static final int MAX_QUANTITY = 99;

    public void validPayment(Map<Integer, List<Order>> orders, int tableNumber){
        if(orders.get(tableNumber)==null){
            throw new IllegalArgumentException(ErrorMessage.NOTHING_TO_PAY);
        }
    }
    public void validQuantity(int quantity){
        if(quantity>MAX_QUANTITY){
            throw new IllegalArgumentException(ErrorMessage.EXCESS_QUANTITY_MESSAGE);
        }
    }
}
