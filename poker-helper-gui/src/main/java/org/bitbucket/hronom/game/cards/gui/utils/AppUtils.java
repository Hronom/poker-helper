package org.bitbucket.hronom.game.cards.gui.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.PatternSyntaxException;

/**
 * Created by hronom on 19.04.15.
 */
public class AppUtils {
    private static final Logger logger = LogManager.getLogger();

    private AppUtils() {
    }

    public static AppInfo loadAppInfo(String propertiesFileName) {
        InputStream inputStream = AppUtils.class.getClassLoader().getResourceAsStream(
            propertiesFileName
        );
        if (inputStream == null) {
            logger.fatal(
                "Property file \"" + propertiesFileName + "\" is not found in the classpath."
            );
            return null;
        }

        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            String version = properties.getProperty("version");
            if (version != null) {
                String[] versionParts = version.split("\\.");
                return new AppInfo(
                    Integer.valueOf(versionParts[0]),
                    Integer.valueOf(versionParts[1]),
                    Integer.valueOf(versionParts[2])
                );
            } else {
                logger.fatal("Property file doesn't contain version.");
                return null;
            }
        } catch (PatternSyntaxException e) {
            logger.fatal("Wrong format of version value: \"" + propertiesFileName + "\".");
        } catch (FileNotFoundException e) {
            logger
                .fatal("Property file \"" + propertiesFileName + "\" not found in the classpath.");
        } catch (IOException e) {
            logger.fatal(e);
        }
        return null;
    }
}
