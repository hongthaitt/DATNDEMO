package starter.configurationGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertyGenerator {
    public static void main(String[] args) {

        // Properties file path.
        String filePath = "serenity.properties";
        Properties prop = new Properties();
        //set up inviroment ,file brower driver
        try (Writer inputStream = new FileWriter(filePath)) {
            String browserHome = System.getenv("BROWSER_HOME");
            System.out.println("hi: "+browserHome);
            if (browserHome.equals("CHROME")) {
                prop.setProperty("webdriver.driver", "chrome");
                prop.setProperty("webdriver.chrome.driver", "src/test/main/resources/chromedriver.exe");
            } else if (browserHome.equals("IE")) {
                prop.setProperty("webdriver.driver", "iExplorer");
                prop.setProperty("webdriver.ie.driver", "src/test/main/resources/IEDriverServer.exe");
            } else {
                prop.setProperty("webdriver.driver", "chrome");
                prop.setProperty("webdriver.chrome.driver", "src/test/main/resources/chromedriver.exe");
            }
            // set project name in report
            prop.setProperty("serenity.project.name", "Automation test for itshot");
            // Storing the properties in the file with a heading comment.
            prop.store(inputStream, "configuration information");
        } catch (IOException ex) {
            System.out.println("Problem occurs when reading file !");
            ex.printStackTrace();
        }
    }
}
