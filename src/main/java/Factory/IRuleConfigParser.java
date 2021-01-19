package Factory;

public interface IRuleConfigParser {
    default RuleConfig parse(String ConfigText) {
        return new RuleConfig();
    }
}
