package controller;

import view.InputView;
import view.OutputView;

public class PosController {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();

    public void start(){
        outputView.printStart();
        int function = inputView.inputFunction();


    }
}
