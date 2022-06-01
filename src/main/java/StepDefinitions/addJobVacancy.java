package StepDefinitions;

import Support.PageSupport;
import Utils.Common;
import Utils.Driver;
import Utils.Global;
import com.google.common.base.Splitter;
import io.cucumber.java.en.*;
import io.testproject.sdk.drivers.web.ChromeDriver;

import java.security.cert.CertificateParsingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class addJobVacancy {
    public ChromeDriver driver = Driver.getInstance().openBrowser();
    public Common cmn = new Common();
    @Then("Add Job Vacancy {string}")
    public void addJobVacancy(String arg0) {
        cmn.click("//input[@value='Add']");
        Common.think(1);
        Map<String, String> map = Splitter.on( ";" ).withKeyValueSeparator( '=' ).split( arg0 );
        System.out.println(map);
        cmn.select("addJobVacancy[jobTitle]",map.get("Job Title"));
        Common.think(1);
        cmn.setTextByName("addJobVacancy[name]",map.get("Vacancy Name"));
        Common.think(1);
        cmn.setTextByName("addJobVacancy[hiringManager]",map.get("Hiring Manager"));
        Common.think(1);
        cmn.setTextByName("addJobVacancy[noOfPositions]",map.get("Number of Positions"));
        Common.think(1);
        cmn.setTextByName("addJobVacancy[description]",map.get("Description"));
        Common.think(1);
        cmn.click("//input[@value='Save']");

    }

    @Then("check available domain")
    public void checkAvailableDomain() {
        String placeholder = "Search names or addresses";
        String button = "submit";
        String classname = "css-0 e1736otp6";
        Common.think(5);
        for(int i =2521;i<2999;i++){
            String searchxpath = "//input[@placeholder='"+placeholder+"']";
            String buttonxpath ="//button[@type='"+button+"']";
            String availablexpath ="//div[@class='"+classname+"']";
            cmn.setText(searchxpath, String.valueOf(i));
            Common.think(2);
            cmn.click(buttonxpath);
            Common.think(10);
            String available = cmn.getReadOnlyText(availablexpath);
            System.out.println("For '"+i+"' Domain is "+available);
        }
    }
}
