package conf;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Utils.JsonUtils;


public final class ConfigurationGetter {
    private static Log logger = LogFactory.getLog(JsonUtils.class);
    private static Properties prop;

    static {
        try {
            prop = new Properties();
            // 配置文件在class目录下
            InputStream in = ConfigurationGetter.class.getClassLoader()
                    .getResourceAsStream("huangting.properties");

            prop.load(in);

        } catch (IOException e) {
            logger.info("ERROR:", e);
        }
    }

    public static String getConfiguration(String key) {
        return prop.getProperty(key);
    }

}