import controller.PosController;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.awt.*;
import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
//        final List<Table> tables = TableRepository.tables();
//        OutputView.printTables(tables);
//
//        final int tableNumber = InputView.inputTableNumber();
//
//        final List<Menu> menus = MenuRepository.menus();
//        OutputView.printMenus(menus);
        PosController posController = new PosController();
        try{
            posController.start();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
