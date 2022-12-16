package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PosController {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();
    public static final List<Table> tables = TableRepository.tables();
    public static final List<Menu> menus = MenuRepository.menus();
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
        int menuNumber = inputView.inputMenu();
    }
}
