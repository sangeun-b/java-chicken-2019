package exception;

public class InputException {

    private static final String REGEX_FUNCTION = "^[1-3]+$";
    public static final String REGEX_MENU = "^[1-6,21-22]+$";
    public static final String REGEX_TABLE = "^[1-3,5-6,8]+$";

    public void validFunction(String function){
        if(!function.matches(REGEX_FUNCTION)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_CHOICE_MESSAGE);
        }
    }
    public void validMenu(String menu){
        if(!menu.matches(REGEX_MENU)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_CHOICE_MESSAGE);
        }
    }
    public void validTable(String table){
        if(!table.matches(REGEX_TABLE)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_CHOICE_MESSAGE);
        }
    }
    public void validQuantity(String quantity){
        if(Integer.parseInt(quantity)<0 || Integer.parseInt(quantity)>99){
            throw new IllegalArgumentException(ErrorMessage.WRONG_CHOICE_MESSAGE);
        }
    }
    public void validPayment(String payment){
        if(Integer.parseInt(payment)!=1 && Integer.parseInt(payment)!= 2){
            throw new IllegalArgumentException(ErrorMessage.WRONG_CHOICE_MESSAGE);
        }
    }
}
