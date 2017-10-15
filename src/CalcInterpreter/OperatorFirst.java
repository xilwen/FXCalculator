package CalcInterpreter;

import java.util.ArrayList;

class OperatorFirst extends Token implements haveOperation {
    private boolean succeed;
    private final int ADD = 1,
            MINUS = 2;
    private int Operation = 0;

    @Override
    public boolean parse(ArrayList<Key> cmd) {
        succeed = false;
        try {
            if (cmd.get(0).get().equals("+")) {
                Operation = ADD;
                cmd.remove(0);
            } else if (cmd.get(0).get().equals("-")) {
                Operation = MINUS;
                cmd.remove(0);
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        succeed = true;
        return true;
    }

    @Override
    public boolean lastOperationSucceed() {
        return succeed;
    }

    @Override
    public double doLastOperation(double a, double b) {
        if (!lastOperationSucceed()) {
            throw new RuntimeException("last op did not succeed");
        }
        if (Operation == ADD) {
            return a + b;
        } else if (Operation == MINUS) {
            return a - b;
        } else {
            throw new RuntimeException("dangling operator occurred");
        }
    }
}
