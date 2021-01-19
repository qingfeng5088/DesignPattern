package Factory.Simple;

import Factory.*;

public class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String ruleConfigFileExtension) {
        IRuleConfigParser parse = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parse = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parse = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parse = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parse = new PropertiesRuleConfigParser();
        }

        return parse;
    }
}
