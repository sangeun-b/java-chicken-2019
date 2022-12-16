package domain;

import java.util.*;

public class OrderRepository {
    private static Map<Integer, List<Order>> orders = new HashMap<>();

    public static Map<Integer,List<Order>> saveOrder(int tableNumber, Order order) {
        saveTable(tableNumber,order);
        return orders;
    }

    public static void printAllOrders(int tableNumber){
        List<Order> allOrders = orders.get(tableNumber);
        for(Order order:allOrders){
            int total = order.getQuantity()*order.getMenu().getPrice();
            System.out.println(order.getMenu().getName() +" "+ order.getQuantity() +" "+total);
        }
    }
    public static Map<Integer,List<Order>> saveTable(int tableNumber,Order order){
        if(checkExistingTable(tableNumber)!=null){
            if(!plusMenuQuantity(orders.get(tableNumber), order)){
                orders.get(tableNumber).add(order);
            }
        }
        if(checkExistingTable(tableNumber)==null){
            List<Order> newOrder = new ArrayList<>();
            newOrder.add(order);
            orders.put(tableNumber,newOrder);
        }
        return orders;
    }
    public static boolean plusMenuQuantity(List<Order> existingOrders, Order newOrder){
        for(Order order: existingOrders) {
            if (order.getMenu() == newOrder.getMenu()) {
                order.addQuantity(newOrder.getQuantity());
                return true;
            }
        }
        return false;
    }
    public static List<Order> checkExistingTable(int tableNumber){
        return orders.get(tableNumber);
    }

}
