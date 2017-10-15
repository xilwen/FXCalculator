package CalcInterpreter;

import java.util.ArrayList;

/*
Interpreter Pattern
  expression := [minus] term [operator1 term]*
  term := number [operator2 number]*
  number := digit [digit]* [.] [digit]*
  minus := -
  operator1 := +|-
  operator2 := ×|÷
  digit := 0|1|2|3|4|5|6|7|8|9
*/

public class Interpreter implements haveResultInDouble {
    private double result;
    private boolean succeed;
    private ArrayList<Key> keyArrayList;
    private Expression expression = new Expression();

    public double interpret(String input){
        if(input.length() == 0) {
            result = 0;
            succeed = true;
            return 0;
        }
        keyArrayList = importKeysFromString(input);
        expression.parse(keyArrayList);
        result = expression.getLastResult();
        succeed = expression.lastOperationSucceed();
        return getLastResult();
    }

    private ArrayList<Key> importKeysFromString(String input) {
        ArrayList<Key> importTmp = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
                importTmp.add(new Key(input.substring(i, i + 1)));
        }
        return importTmp;
    }

    @Override
    public double getLastResult() {
        if(!expression.lastOperationSucceed()){
            throw new RuntimeException("last op did not success");
        }
        return result;
    }

    @Override
    public boolean lastOperationSucceed() {
        return succeed;
    }
}
