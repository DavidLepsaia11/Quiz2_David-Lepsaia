
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;




public class WebFormsTest {
    WebDriver driver;
    @BeforeMethod
    public void  open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void selectFromDropDown() throws InterruptedException {

        //  Navigate to the Current link
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        //  Choose any (not default) programming language from dropdown and ensure that it was selected
        Select dropdown1 = new Select( driver.findElement(By.cssSelector("select[id='dropdowm-menu-1']")));
        dropdown1.selectByVisibleText("C#");
        Thread.sleep(1000);

        List<WebElement> selectedOptions =  dropdown1.getAllSelectedOptions();
        for (WebElement selectedOption : selectedOptions) {
            String someString = selectedOption.getText();
            if (selectedOption.isSelected())
            {
                System.out.println(someString);
            }
        }
    }
    @Test
    public void TestCheckbox()throws InterruptedException
    {
        //  Navigate to the Current link
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        //Click on all unselected checkboxes
        List<WebElement> allCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement checkbox : allCheckBox )
        {
            if(!checkbox.isSelected())
            {
                checkbox.click();
            }
        }
    }
    @Test
    public void TestRadioButton()
    {
        //  Navigate to the Current link
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        //Click on 'Yellow' radio button
        WebElement radioYellow = driver.findElement(By.xpath("//input[@value='yellow' and @type='radio']"));
        radioYellow.click();
    }
    @Test
    public void TestSelectedAndDisabled()
    {
        //  Navigate to the Current link
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        //  In 'Selected & Disabled' section check that 'Orange' option in dropdown is disabled
        Select dropdown = new Select( driver.findElement(By.cssSelector("select[id='fruit-selects']")));

        //Get all options
        List<WebElement> options = dropdown.getOptions();

        for (int j = 0; j < options.size(); j++)
        {
            if (!options.get(j).isEnabled())
            {
                System.out.println(options.get(j).getText());
            }
        }
    }
    // Task 2 :
    @Test
    public void TestProgressBar()
    {
        //  Navigate to the Current link
        driver.get(" https://demoqa.com/progress-bar");

        //  Click to 'Start' button
        WebElement button = driver.findElement(By.xpath("//button[@type='button' and contains(text(),'Start')]"));
        button.click();

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
