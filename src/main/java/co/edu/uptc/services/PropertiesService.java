package co.edu.uptc.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesService {

    Properties p = new Properties();

    public void load() {

        try {
            p.load(new FileInputStream("evaluacion1\\src\\main\\resources\\config.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperties(String keyName) {
        load();
        return p.getProperty(keyName);
    }
}
