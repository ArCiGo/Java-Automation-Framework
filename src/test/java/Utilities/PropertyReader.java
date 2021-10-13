package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public String getProperty(String filename, String name) {
        Properties properties = new Properties();
        InputStream input = null;
        String propertyValue = null;

        try {
            input = this.getClass().getClassLoader().getResourceAsStream(filename);
            properties.load(input);
            propertyValue = properties.getProperty(name);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            closeInput(input);

            return propertyValue;
        }
    }

    private void closeInput(InputStream input) {
        try {
            input.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
