package Factory.Simple;

import Factory.*;

public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        if (parser == null) {
                throw  new Exception("Rule config file format is not supported:" + ruleConfigFileExtension);
        }

        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // ...解析文件名获取扩展名，比如rule.json，返回json
        return filePath.split("\\.")[1];
    }
}
