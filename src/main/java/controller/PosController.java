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
    public static TotalPrice totalPrice = new TotalPrice();
    public static final int ORDER = 1;
    public static final int PAY = 2;
    public static final int QUIT = 3;
    public static boolean isRunning = true;

    public void start(){
        while(isRunning){
            startMain();
        }
    }
    public void startMain(){
        outputView.printStart();
        int function = inputView.inputFunction();
        run(function);
    }
    public void run(int function){
        if(function==ORDER) {
            createOrder();
        }
        if(function==PAY){
            makePayment();
        }
        if(function==QUIT)
            isRunning=false;
    }
    public void createOrder(){
        outputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        outputView.printMenus(menus);
        Menu menu = MenuRepository.findMenuByNumber(inputView.inputMenu());
        int menuQuantity = inputView.inputQuantity();
        if(OrderRepository.checkTotalQuantity(tableNumber,menuQuantity)){
            orders = OrderRepository.saveOrder(tableNumber,new Order(menu,menuQuantity));
        }
        if(!OrderRepository.checkTotalQuantity(tableNumber,menuQuantity)){
            outputView.printExcessQuantity();
            start();
        }
    }
    public void makePayment(){
        outputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        outputView.printTotalOrders();
        OrderRepository.printAllOrders(tableNumber);
        int payment = inputView.inputPaymentMethod();
        outputView.printTotalPrice();
        System.out.println(totalPrice.calculateTotalPrice(orders.get(tableNumber), payment)+"\n");

    }
}
