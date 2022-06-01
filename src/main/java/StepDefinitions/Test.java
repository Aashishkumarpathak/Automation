package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import Utils.Common;
import Utils.Driver;
import Utils.Global;
import io.testproject.sdk.drivers.web.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import Support.PageSupport;

import java.io.File;
import java.io.IOException;

public class Test {
    public ChromeDriver driver = Driver.getInstance().openBrowser();
    public Common cmn = new Common();
    @Then("search for current PM of INDIA")
    public void searchForCurrentPMOfINDIA() {
        cmn.setText("//input[@type='text']","Current PM of INDIA");
        Common.think(2);
        driver.findElementByXPath("//input[@type='text']").sendKeys(Keys.ENTER);
        
    }

    @Then("get PM Name")
    public void getPMName() {
        String Name = cmn.getReadOnlyText("//span[contains(text(),'Prime minister')]//following::a[1]");
        System.out.println(Name);
    }

    @Then("Navigate to HTML Quiz")
    public void navigateToHTMLQuiz() {
        cmn.click("//a[@id='navbtn_exercises']");
        Common.think(2);
        cmn.click("//a[contains(text(),'HTML Quiz')]");
        Common.think(2);

    }

    @And("Start the QUIZ")
    public void startTheQUIZ() throws IOException {
        String Radiobtn = "//input[@type=\"radio\"][@value=2]/following::span[1]";
        cmn.click("//a[contains(text(),'Start the HTML Quiz ❯')]");
        Common.think(2);
        for(int i=0;i<=40;i++){
            cmn.click(Radiobtn);
            cmn.click("//button[contains(text(),'Next ❯')]");
            Common.think(2);
        }
        File srcFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //scenario.embed(screenshot, "image/png"); //stick it in the report
        FileUtils.copyFile(srcFile, new File("/Users/aaspatha/Desktop/PersonalGit/Automation/src/main/java/ScreenShots/SCORE.jpg"));
    }


}
