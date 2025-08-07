package day24;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Task02 {

    // Singleton Config Manager as inner static class
    static class SingletonDPConfigManager {

        private static SingletonDPConfigManager ConfigManagerInstance;
        private Properties properties;

        // Private constructor
        private SingletonDPConfigManager() {
            properties = new Properties();
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                if (input == null) {
                    System.out.println("We can't find config.properties");
                    return;
                }
                properties.load(input);
            } catch (IOException ioexp) {
                ioexp.printStackTrace();
            }
        }

        // Getter method to retrieve property value by key
        public String getProperty(String key) {
            return properties.getProperty(key);
        }

        // Static synchronized method to return the singleton instance
        public static synchronized SingletonDPConfigManager getConfigManagerInstance() {
            if (ConfigManagerInstance == null) {
                ConfigManagerInstance = new SingletonDPConfigManager();
            }
            return ConfigManagerInstance;
        }
    }

    // Example usage
    public static void main(String[] args) {
        SingletonDPConfigManager config = SingletonDPConfigManager.getConfigManagerInstance();

        // Example: read value for key "app.name"
        String appName = config.getProperty("app.name");
        System.out.println("App Name: " + appName);
    }
}

