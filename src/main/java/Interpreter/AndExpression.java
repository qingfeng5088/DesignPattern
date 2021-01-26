package Interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AndExpression implements IExpression {
    private final List<IExpression> expressions = new ArrayList<>();


    public AndExpression(String strAndExpression) {
        String[] strExpressions = strAndExpression.trim().split("&&");
        for (String strExpression : strExpressions) {
            if (strExpression.contains(">")) {
                expressions.add(new GreaterExpression(strExpression));
            } else if (strExpression.contains("<")) {
                expressions.add(new LessExpression(strExpression));
            } else if (strExpression.contains("==")) {
                expressions.add(new EqualExpression(strExpression));
            } else {
                throw new RuntimeException("Expression is invalid:" + strAndExpression);
            }
        }
    }


    public AndExpression(List<IExpression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        return expressions.stream().allMatch(x -> x.interpret(stats));
    }
}
