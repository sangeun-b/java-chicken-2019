package domain;

import java.util.List;

public class TotalPrice {

    public int calculateTotalPrice(List<Order> orders, int paymentMethod){
        int totalPrice = calculatePrice(orders);
        int discountQuantity = discountQuantity(orders);
        int discountPrice = (int) (totalPrice*(discountQuantity*0.01));
        totalPrice = totalPrice-discountPrice;
        if(paymentMethod==2){
            discountPrice = (int) (totalPrice*(5*0.01));
        }
        return totalPrice-discountPrice;
    }
    public int calculatePrice(List<Order> orders){
        int allPrice = 0;
        for(Order order: orders){
            allPrice += order.getQuantity()*order.getMenu().getPrice();
        }
        return allPrice;
    }
    public int discountQuantity(List<Order> orders){
        int totalQuantity = 0;
        for(Order order: orders){
            totalQuantity += order.getQuantity();
        }
        if(totalQuantity>=10){
            return totalQuantity%10;
        }
        return 0;

    }

}
