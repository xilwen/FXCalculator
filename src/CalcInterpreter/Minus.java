package CalcInterpreter;

import java.util.ArrayList;

class Minus extends Token {
    @Override
    public boolean parse(ArrayList<Key> cmd) {
        try {
            if (cmd.get(0).get().equals("-")) {
                cmd.remove(0);
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
