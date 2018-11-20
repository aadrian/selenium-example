import com.mycorp.Selenium;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public static final String HELP = "\t\tUse 'cucumber', 'chrome', or 'firefox' as parameter.";

    public static void main(String[] args) {
        App app = new App();
        Selenium selenium = new Selenium();
        if(args.length == 0) {
            System.out.println("----> Missing arguments:");
            System.out.println(HELP);
            return;
        } else if (args.length == 1) {
            if("firefox".equals(args[0])) {
                app.processWithFirefox();
            } else if("chrome".equals(args[0])) {
                app.processWithChrome();
            } else if("cucumber".equals(args[0])) {
                System.out.println(" ... Call Cucumber with parameters here ...");
            } else {
                System.out.println("---> Unsupported parameter '"+args[0]+"'!");
                System.out.println(HELP);
                return;
            }
        }
    }

    public void processWithFirefox() {
        System.out.println("App.processWithFirefox");
        Selenium selenium = new Selenium();
        WebDriver driver = selenium.initFirefox();
        boolean navigated = selenium.step_navigate(driver);
        boolean titled = selenium.step_check_title(driver);
        if(navigated && titled) { System.out.println(" ---> processWithFirefox successfully!"); }
    }
    public void processWithChrome() {
        System.out.println("App.processWithChrome");
        Selenium selenium = new Selenium();
        WebDriver driver = selenium.initChrome();
        boolean navigated = selenium.step_navigate(driver);
        boolean titled = selenium.step_check_title(driver);
        if(navigated && titled) { System.out.println(" ---> processWithChrome successfully!"); }
    }

    // demo method and unit test as generated by gradle ...
    public String getGreeting() {
        return "Hello world.";
    }
}
