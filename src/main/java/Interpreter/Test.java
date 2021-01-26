package Interpreter;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // key1 > 100 && key2 < 1000 || key3 ==200
        String ruleExpression = " ((key1 > 100 && (key2 < 1000 || (key3 == 201 || key5 == 6))) && key4 == 88)";

        Map<String, Long> stats = new HashMap<>();
        stats.put("key1", 101L);
        stats.put("key2", 1002L);
        stats.put("key3", 201L);
        stats.put("key4", 88L);
        stats.put("key5", 5L);


        AlertRuleInterpreter alertRuleInterpreter = new AlertRuleInterpreter(ruleExpression, stats);
        System.out.println(alertRuleInterpreter.interpret());
    }
}
