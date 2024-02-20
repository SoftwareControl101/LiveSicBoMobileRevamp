package utilities.objects;

import org.openqa.selenium.By;

public class Component {

    /***************************************************************************************************************
     * These are the variables for each component.
     ***************************************************************************************************************/

    private final String name;
    private final String type;
    private final String page;
    private final By path;

    /***************************************************************************************************************
     * This is the constructor for each component.
     ***************************************************************************************************************/

    public Component(String name, String type, String page, String path) {
        this.name = name;
        this.page = page;
        this.type = type;
        this.path = By.xpath(path);
    }

    /***************************************************************************************************************
     * These methods are meant for getting the variables for each test result.
     ***************************************************************************************************************/

    public String getName() { return name; }

    public String getType() { return type; }

    public String getPage() { return page; }

    public By getPath() { return path; }

}
