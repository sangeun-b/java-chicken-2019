package view;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_TABLE = "\n## 주문할 테이블을 선택하세요.";
    public static final String INPUT_FUNCTION = "## 원하는 기능을 선택하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public int inputTableNumber() {
        System.out.println(INPUT_TABLE);
        return Integer.parseInt(Console.readLine());
    }
    public int inputFunction(){
        System.out.println(INPUT_FUNCTION);
        return Integer.parseInt(Console.readLine());

    }
}
