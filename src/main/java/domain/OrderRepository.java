package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRepository {
    private static Map<Integer, List<Order>> orders = new HashMap<>();

    public static Map<Integer,List<Order>> saveOrder(int tableNumber, Order order){
        if(orders.get(tableNumber)!=null){
            orders.get(tableNumber).add(order);
        }
        if(orders.get(tableNumber)==null){
            List<Order> newOrder = new ArrayList<>();
            newOrder.add(order);
            System.out.println(newOrder.stream().collect(Collectors.toList()));
            orders.put(tableNumber,newOrder);
        }
        return orders;
    }

}
