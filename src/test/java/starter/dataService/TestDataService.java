package starter.dataService;

import java.io.FileInputStream;
import java.util.Properties;

public class TestDataService {
    //read xpath from file properties
    //as storage of project
    public static Properties properties;

    public static void setProperties(String relativeFilePath) {
        properties = new Properties();
        try {
            //FileInputStream file = new FileInputStream(System.getProperty("user.dir") + relativeFilePath);
            FileInputStream file = new FileInputStream(relativeFilePath);
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("hi: "+System.getProperty("user.dir"));
       System.out.println("test: " +properties.getProperty("emailLogin"));
    }

//    public static void main(String[] args) {
//        TestDataService.setProperties("src\\test\\resources\\data_test\\data.properties");
//        String a = TestDataService.properties.getProperty("homePage");
//        System.out.println("aaaa: "+a);
//    }


}
