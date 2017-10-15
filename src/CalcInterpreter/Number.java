package CalcInterpreter;

import java.util.ArrayList;

class Number extends Token implements haveResultInDouble {
    private boolean lastSucceed;
    private double result;
    private Digit digit = new Digit();

    @Override
    public boolean parse(ArrayList<Key> cmd) {
        if (digit.parse(cmd)) {
            result = digit.getLastResult();
        } else {
            return false;
        }
        while (digit.parse(cmd)) {
            result *= 10;
            result += digit.getLastResult();
        }

        if (cmd.size() > 0 && cmd.get(0).get().equals(".")) {
            cmd.remove(0);
            double negativePowerOf10 = -1;
            if(digit.parse(cmd)){
                result += (digit.getLastResult() * Math.pow(10, negativePowerOf10));
                --negativePowerOf10;
            }else{
                return false;
            }
            while(digit.parse(cmd)) {
                result += (digit.getLastResult() * Math.pow(10, negativePowerOf10));
                --negativePowerOf10;
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
        return result;
    }
}
