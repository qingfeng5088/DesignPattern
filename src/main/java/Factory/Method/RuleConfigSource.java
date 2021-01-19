package Factory.Method;

import Factory.IRuleConfigParser;
import Factory.RuleConfig;

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension.toLowerCase());
        IRuleConfigParser parser = parserFactory.createParser();

        //从ruleConfigFilePath文件中读取配置文本到configText中
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // ...解析文件名获取扩展名，比如rule.json，返回json
        return filePath.split("\\.")[1];
    }
}
