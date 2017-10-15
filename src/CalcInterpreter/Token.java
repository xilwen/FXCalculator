package CalcInterpreter;

import java.util.ArrayList;

public abstract class Token {
    protected String name = "";
    protected double value = 0;

    Token() {}

    Token(String n) {
        name = n;
    }
    public abstract boolean parse(ArrayList<Key> cmd);
}

interface haveResultInDouble{
    boolean lastOperationSucceed();
    double getLastResult();
}

interface haveOperation{
    boolean lastOperationSucceed();
    double doLastOperation(double a, double b);
}