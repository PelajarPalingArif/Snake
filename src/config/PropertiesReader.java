package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static int clock = 1000;
    static {
        System.out.println("Current Directory: " + new java.io.File(".").getAbsolutePath());
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/config/game.properties")){
            properties.load(fileInputStream);
            PropertiesReader.clock = Integer.parseInt(properties.getProperty("clock"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
