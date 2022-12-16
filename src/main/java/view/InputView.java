package view;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import org.w3c.dom.ls.LSOutput;

public class InputView {
    private static final String INPUT_TABLE = "## 테이블을 선택하세요.";
    public static final String INPUT_FUNCTION = "## 원하는 기능을 선택하세요.";
    public static final String INPUT_MENU = "## 등록할 메뉴를 선택하세요.";
    public static final String INPUT_QUANTITY = "## 메뉴의 수량을 입력하세요.";
    private static final String INPUT_PAYMENT = "## 1번 테이블의 결제를 진행합니다.\n" + "## 신용 카드는 1번, 현금은 2번";

    private static final Scanner scanner = new Scanner(System.in);

    public int inputTableNumber() {
        System.out.println(INPUT_TABLE);
        return Integer.parseInt(Console.readLine());
    }
    public int inputFunction(){
        System.out.println(INPUT_FUNCTION);
        return Integer.parseInt(Console.readLine());

    }
    public int inputMenu(){
        System.out.println(INPUT_MENU);
        return Integer.parseInt(Console.readLine());
    }
    public int inputQuantity(){
        System.out.println(INPUT_QUANTITY);
        return Integer.parseInt(Console.readLine());
    }
    public int inputPaymentMethod(){
        System.out.println(INPUT_PAYMENT);
        return Integer.parseInt(Console.readLine());
    }
}
