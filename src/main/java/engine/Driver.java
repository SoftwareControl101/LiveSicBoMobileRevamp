package engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new GoogleChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(400, 1000));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int windowWidth = driver.manage().window().getSize().getWidth();

        driver.manage().window().setPosition(new Point(screenWidth - windowWidth, 0));
    }

    public void close() {
        driver.quit();
    }

}
