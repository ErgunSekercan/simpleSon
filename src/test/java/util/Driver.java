package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing access
    to the object of this class from outside the class
     */
    public Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */

    //private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */

    public static WebDriver getDriver(){

        if (driverPool.get()==null){

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside out code, from configuration.properties
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that will be return from Configuration.properties file
            switch statement will determine the case, and open the matching browser
             */
            switch (browserType){

                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    //options.setCapability("browserVersion","118.0.5993.89");
                    options.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "chrome_english":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions optionsForEnglish = new ChromeOptions();
                    optionsForEnglish.addArguments("--remote-allow-origins=*");
                    optionsForEnglish.addArguments("--lang=eng-US");
                    driverPool.set(new ChromeDriver(optionsForEnglish));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }

    public static void loginPeyk(){
        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
    }

    // This method will make sure our driver value is always null after using quit() method
    public static void closeDriver() {
        /*if (driverPool.get() != null) {
            driverPool.get().quit(); // this line will terminate the existing session. Value will not even be null
            driverPool.remove();
        }*/
        if(driverPool.get() == null){
            driverPool.get().quit();
        }
    }
}

