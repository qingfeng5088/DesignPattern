package Interpreter;

import java.util.Map;

public interface IExpression {
    boolean interpret(Map<String,Long> stats);
}
