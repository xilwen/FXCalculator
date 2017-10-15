package CalcInterpreter;

import java.util.ArrayList;

class Term extends Token implements haveResultInDouble{
    private double Result;
    private Number number = new Number();
    private OperatorSecond op2 = new OperatorSecond();
    private boolean lastSucceed;

    @Override
    public boolean parse(ArrayList<Key> cmd) {
        Result = 0;
        lastSucceed = false;
        if(number.parse(cmd)){
            Result = number.getLastResult();
        } else {
            return false;
        }
        while(op2.parse(cmd)){
            if(number.parse(cmd)){
                Result = op2.doLastOperation(Result, number.getLastResult());
            }else{
                return false;
            }
        }
        lastSucceed = true;
        return true;
    }

    @Override
    public double getLastResult() {
        if(!lastOperationSucceed()){
            throw new RuntimeException("last parse did not succeed");
        }
        return Result;
    }

    @Override
    public boolean lastOperationSucceed() {
        return lastSucceed;
    }
}
