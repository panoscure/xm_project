package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Properties {

    public static final java.util.Properties properties = new java.util.Properties();

    public static void loadProperties(String filename) {
        InputStream inputStream = Properties.class.getClassLoader().getResourceAsStream(filename);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Object> itr = properties.keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            System.setProperty(key, properties.getProperty(key));
        }
    }

    public static String getPropertyValue(String key) {
        return properties.getProperty(key);
    }

    public static void setPropertyValue(String key, String value) {
        properties.setProperty(key, value);
    }
}
