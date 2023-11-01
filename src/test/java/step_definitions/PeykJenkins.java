package step_definitions;

import io.cucumber.java.en.When;
import org.junit.Assert;
import util.BrowserUtils;
import util.Driver;
import pages.PEYK_Pages;

public class PeykJenkins extends Driver {

    PEYK_Pages peyk_pages = new PEYK_Pages();

    @When("peyk bordro")
    public void bordro(){
        System.out.println("1.Adım");

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        peyk_pages.TcNo.sendKeys("admin_004329");
        peyk_pages.sifre.sendKeys("Ab,12345");
        peyk_pages.giris.click();
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);

        peyk_pages.ucretBordrosu.click();
        BrowserUtils.waitFor(3);
        //String ucretBordrosu = peyk_pages.ucretBordrosuYukle.getText();
        Assert.assertEquals(peyk_pages.ucretBordrosuYukle.getText(),"Ücret Bordrosu Yükle");
        BrowserUtils.waitFor(2);
        System.out.println("2.Adım");
        closeDriver();
    }
}
