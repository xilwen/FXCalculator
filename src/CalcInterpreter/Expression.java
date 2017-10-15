package CalcInterpreter;

import java.util.ArrayList;

class Expression extends Token implements haveResultInDouble {
    private double result;
    private boolean lastSucceed;
    private Minus minus = new Minus();
    private Term term = new Term();
    private OperatorFirst op1 = new OperatorFirst();

    @Override
    public boolean parse(ArrayList<Key> cmd) {
        result = 1;
        lastSucceed = false;
        if (minus.parse(cmd)) {
            result = -1;
        }
        if (term.parse(cmd)) {
            result = result * term.getLastResult();
        } else {
            return false;
        }
        while (op1.parse(cmd)) {
            if (term.parse(cmd)) {
                result = op1.doLastOperation(result, term.getLastResult());
            } else {
                return false;
            }
        }
        lastSucceed = true;
        return true;
    }

    @Override
    public boolean lastOperationSucceed() {
        return lastSucceed;
    }

    @Override
    public double getLastResult() {
        if(!lastOperationSucceed()){
            throw new RuntimeException("The last parse did not success.");
        }
        return result;
    }
}
