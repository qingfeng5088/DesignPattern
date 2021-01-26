package Interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AlertRuleInterpreter {
    private final IExpression ruleExpression;

    private final Map<String, Long> stats;

    // key1 > 100 && key2 < 1000 || key3 ==200
    public AlertRuleInterpreter(String ruleExpression, Map<String, Long> stats) {
        stats.put("m", 1L);
        this.stats = stats;

        this.ruleExpression = new OrExpression(doBrackets(ruleExpression));
    }

    private String doBrackets(String ruleExpression) {
        if (!ruleExpression.contains("(")) return ruleExpression;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ruleExpression.length(); i++) {
            if (ruleExpression.charAt(i) == '(') stack.push(i);
            if (ruleExpression.charAt(i) == ')') {
                int start = stack.pop();
                String subRuleExpression = ruleExpression.substring(start + 1, i);
                IExpression orExpression = new OrExpression(subRuleExpression);

                subRuleExpression = String.format("(%s)", subRuleExpression);
                if (orExpression.interpret(stats)) {
                    ruleExpression = ruleExpression.replace(subRuleExpression, "m == 1");
                } else {
                    ruleExpression = ruleExpression.replace(subRuleExpression, "m == 0");
                }
            }
        }

        return doBrackets(ruleExpression);
    }

    public boolean interpret() {
        return ruleExpression.interpret(stats);
    }

}
