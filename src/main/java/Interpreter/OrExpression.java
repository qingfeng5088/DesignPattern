package Interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrExpression implements IExpression {
    private final List<IExpression> expressions = new ArrayList<>();


    public OrExpression(String strOrExpression) {
        String[] andExpressions = strOrExpression.trim().split("\\|\\|");
        for (String andExpression : andExpressions) {
            expressions.add(new AndExpression(andExpression));
        }
    }


    public OrExpression(List<IExpression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        return expressions.stream().anyMatch(x -> x.interpret(stats));
    }
}
