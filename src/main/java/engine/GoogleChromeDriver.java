package engine;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;

public class GoogleChromeDriver extends ChromeDriver {

    GoogleChromeDriver() {
        super(getCaps());
    }

    private static ChromeOptions getCaps() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chromeOptions.setCapability("ignoreZoomSetting", true);
        chromeOptions.setCapability("requireWindowFocus", false);
        chromeOptions.setCapability("enablePersistentHover", false);

        chromeOptions.addArguments("--headless");
        chromeOptions.setExperimentalOption("mobileEmulation", getMobileEmulation());

        return chromeOptions;
    }

    private static Map<String, Object> getMobileEmulation() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("deviceName", "Nexus 5");
        deviceMetrics.put("width", 460);
        deviceMetrics.put("height", 840);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        Map<String, Object> clientHints = new HashMap<>();
        clientHints.put("platform", "Android");
        clientHints.put("mobile", true);
        mobileEmulation.put("clientHints", clientHints);

        return mobileEmulation;
    }

}


