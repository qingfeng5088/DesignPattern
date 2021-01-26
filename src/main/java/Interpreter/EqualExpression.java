package Interpreter;

import java.util.Map;

/**
 * key1 > 100 && key2 < 1000 || key3 == 200
 */
public class EqualExpression implements IExpression {
    private final String key;
    private final Long value;

    public EqualExpression(String strExpression) {
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals("==")) {
            throw new RuntimeException("Expression is invalid:" + strExpression);
        }

        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2].trim());
    }

    public EqualExpression(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(key)) {
            System.out.println("检查对象中不包含" + key);
            return false;
        }
        Long compareValue = stats.get(key);
        boolean ret = compareValue.equals(value);
        if (!ret) {
            System.out.println(key + "==" + value + " 不成立,实际值:" + compareValue);
        }

        return ret;
    }
}
