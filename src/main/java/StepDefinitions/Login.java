package StepDefinitions;

import Support.PageSupport;
import Utils.Common;
import Utils.Driver;
import Utils.Global;
import io.cucumber.java.en.*;
import io.testproject.sdk.drivers.web.ChromeDriver;

import java.security.cert.CertificateParsingException;
import java.util.List;

public class Login {
    public ChromeDriver driver = null;
    public PageSupport obj = new PageSupport();
    public Common cmn = new Common();

    @Given("Launched url {string}")
    public void launchedUrl(String URL) {
        driver = Driver.getInstance().openBrowser();
        if(URL.equalsIgnoreCase("GLOBAL"))
            driver.get(Global.LaunchURL);
        else
            driver.get(URL);

        //getDriver().report().step("Step 'Navigate to '~?~ApplicationURL~?~'' failed", ex.getMessage(), false, true);
    }


    @Given("Enter dealership name is required")
    public void enter_dealership_name_is_required() {
        driver = Driver.getInstance().openBrowser();
        driver.get(Global.LaunchURL);


    }

    @When("I set my Username as {string} and Password as {string}")
    public void iSetMyUsernameAsAndPasswordAs(String arg0, String arg1) {
//        Common.think(5);
//        cmn.clickButton("Login");
        Common.think(1);
        cmn.setText("//input[@name='txtUsername']",arg0);
        Common.think(1);
        cmn.setText("//input[@name='txtPassword']",arg1);
        Common.think(1);
        cmn.click("//input[@type='submit']");

    }

    @Then("Verify Message {string}")
    public void verifyMessage(String arg0) {
      cmn.findTextInPage(arg0, true);
    }

    @Then("Navigate to {string}")
    public void navigateTo(String arg0) {
        String[] navigation = arg0.split(">");
        for (String a : navigation) {
            System.out.println(a);
            try{
                System.out.println("Finding Navigation in all tabs");
                cmn.click("//div[@id='mainMenu']//li[@class='main-menu-first-level-list-item']//a[@id='"+a+"']");
            }catch (Exception e){
                try{
                    System.out.println("Finding Navigation in Current tabs");
                    cmn.click("//div[@id='mainMenu']//li[@class='current main-menu-first-level-list-item']//a[@id='"+a+"']");
                }catch (Exception f) {
                    System.out.println("Navigation not Found");
                }
            }

        }
    }
}