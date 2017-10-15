package CalcInterpreter;

import java.util.ArrayList;

class Digit extends Token implements haveResultInDouble {
    private boolean succeed;
    private double result;
    private char ch;

    @Override
    public boolean parse(ArrayList<Key> cmd) {
        succeed = false;
        try {
            ch = cmd.get(0).get().charAt(0);
        } catch(IndexOutOfBoundsException e){
            return false;
        }
        if (!Character.isDigit(ch)) {
            return false;
        }
        result = ch - '0';
        cmd.remove(0);
        succeed = true;
        return true;
    }

    @Override
    public boolean lastOperationSucceed() {
        return succeed;
    }

    @Override
    public double getLastResult() {
        return result;
    }
}
