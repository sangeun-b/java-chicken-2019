package view;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import exception.InputException;
import org.w3c.dom.ls.LSOutput;

public class InputView {
    private static final String INPUT_TABLE = "\n\n## 테이블을 선택하세요.";
    public static final String INPUT_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String INPUT_MENU = "## 등록할 메뉴를 선택하세요.";
    public static final String INPUT_QUANTITY = "\n## 메뉴의 수량을 입력하세요.";
    private static final String INPUT_PAYMENT = "\n## 1번 테이블의 결제를 진행합니다.\n" + "## 신용 카드는 1번, 현금은 2번";

    private static final Scanner scanner = new Scanner(System.in);
    private static InputException inputException = new InputException();

    public int inputTableNumber() {
        System.out.println(INPUT_TABLE);
        String table = Console.readLine();
        inputException.validTable(table);
        return Integer.parseInt(table);
    }
    public int inputFunction(){
        System.out.println(INPUT_FUNCTION);
        String function = Console.readLine();
        inputException.validFunction(function);
        return Integer.parseInt(function);

    }
    public int inputMenu(){
        System.out.println(INPUT_MENU);
        String menu = Console.readLine();
        inputException.validMenu(menu);
        return Integer.parseInt(menu);
    }
    public int inputQuantity(){
        System.out.println(INPUT_QUANTITY);
        String quantity = Console.readLine();
        inputException.validQuantity(quantity);
        System.out.println();
        return Integer.parseInt(quantity);
    }
    public int inputPaymentMethod(){
        System.out.println(INPUT_PAYMENT);
        String payment = Console.readLine();
        inputException.validPayment(payment);
        return Integer.parseInt(payment);
    }
}
