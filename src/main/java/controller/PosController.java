package controller;

import domain.*;
import org.mockito.internal.matchers.Or;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class PosController {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();
    public static final List<Table> tables = TableRepository.tables();
    public static final List<Menu> menus = MenuRepository.menus();
    public static Map<Integer,List<Order>> orders = new HashMap<>();
    public void start(){
        outputView.printStart();
        int function = inputView.inputFunction();
        if(function!=3){
            run();
        }
    }
    public void run(){
        outputView.printTables(tables);
        int tableNumber = inputView.inputTableNumber();
        outputView.printMenus(menus);
        Menu menu = MenuRepository.findMenuByNumber(inputView.inputMenu());
        int menuQuantity = inputView.inputQuantity();
        orders = OrderRepository.saveOrder(tableNumber,new Order(menu,menuQuantity));

    }
}
