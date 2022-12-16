package view;

import domain.Menu;
import domain.OrderRepository;
import domain.Table;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ %s ┘";
    private static final String ORDER_BOTTOM_LINE = "*";
    private static final String NOT_ORDER_BOTTOM_LINE = "-";
    private static final String START_MESSAGE = "## 메인화면\n"+ "1 - 주문등록\n" + "2 - 결제하기\n" + "3 - 프로그램 종료\n";
    private static final String TABLE_MESSAGE = "\n## 테이블 목록";
    private static final String TOTAL_ORDER_MESSAGE = "## 주문내역\n"+"메뉴 수량 금액";
    private static final String TOTAL_PRICE_MESSAGE = "\n## 최종 결제할 금액";


    public static void printStart(){
        System.out.println(START_MESSAGE);

    }
    public static void printTables(final List<Table> tables) {
        System.out.println(TABLE_MESSAGE);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
//        printLine(BOTTOM_LINE, size);
        List<Integer> tableNumbers = Stream.of(1,2,3,5,6,8).collect(Collectors.toList());
        printTableBottom(tableNumbers);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }
    private static void printTableBottom(List<Integer> tableNumbers){
        for(Integer tableNumber: tableNumbers){
            if(OrderRepository.checkExistingTable(tableNumber)!=null){
                System.out.printf(BOTTOM_LINE,ORDER_BOTTOM_LINE);
            }
            if(OrderRepository.checkExistingTable(tableNumber)==null){
                System.out.printf(BOTTOM_LINE,NOT_ORDER_BOTTOM_LINE);
            }
        }
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
    public static void printTotalOrders(){
        System.out.println(TOTAL_ORDER_MESSAGE);
    }

    public static void printTotalPrice(){
        System.out.println(TOTAL_PRICE_MESSAGE);
    }
}
