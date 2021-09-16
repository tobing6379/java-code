package design_pattern.factory;

/**
 * @author tobing
 * @date 2021/9/5 20:31
 * @description
 */
public class RuleConfigFactory {
    public RuleConfig load(String ruleConfigFile) {
        String ruleConfigFileExtension = getFileExtentsion(ruleConfigFile);
        RuleConfig config = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            config = new JsonRuleConfig();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            config = new XmlRuleConfig();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            config = new YamlRuleConfig();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            config = new PropertiesRuleConfig();
        } else {
            throw new RuntimeException(
                    "Rule config file format is not supported: " + ruleConfigFile);
        }
        return config;
    }

    private String getFileExtentsion(String ruleConfigFile) {
        return ruleConfigFile.split("\\.")[1];
    }
}
