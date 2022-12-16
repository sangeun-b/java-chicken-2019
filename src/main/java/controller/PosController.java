package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PosController {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();
    public static final List<Table> tables = TableRepository.tables();
    public static final List<Menu> menus = MenuRepository.menus();
    public static Map<Integer,List<Order>> orders = new HashMap<>();
    public void start(){
        outputView.printStart();
        int function = inputView.inputFunction();
        while(function!=3){
            run(function);
        }
    }
    public void run(int function){
        if(function==1) {
            createOrder();
        }
        if(function==2){
            makePayment();
        }
        start();

    }
    public void createOrder(){
        outputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        outputView.printMenus(menus);
        Menu menu = MenuRepository.findMenuByNumber(inputView.inputMenu());
        int menuQuantity = inputView.inputQuantity();
        orders = OrderRepository.saveOrder(tableNumber,new Order(menu,menuQuantity));
    }
    public void makePayment(){
        outputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        OrderRepository.printAllOrders(tableNumber);
    }
}
