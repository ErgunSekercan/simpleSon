package step_definitions;

import io.cucumber.java.en.When;
import io.cucumber.java.tr.Eğerki;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import util.BrowserUtils;
import util.Driver;
import pages.PEYK_Pages;

public class PeykJenkins extends Driver {

    PEYK_Pages peyk_pages = new PEYK_Pages();

    @Eğerki(": Ücret Bordrosu özelliğini test etmek isterseniz")
    public void bordro(){

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

        peyk_pages.ucretBordrosuYukle.click();
        BrowserUtils.waitFor(2);
        String ucBordYuk = peyk_pages.ucretBordrosuYukle.getText();
        Assert.assertEquals(ucBordYuk,"Ücret Bordrosu Yükle");
        BrowserUtils.waitFor(2);

        peyk_pages.donem.click();
        BrowserUtils.waitFor(2);
        peyk_pages.tem.click();
        peyk_pages.evet.click();
        BrowserUtils.waitFor(3);

        peyk_pages.bordroPdfYukleyiniz.sendKeys("C:\\Users\\Kolaysoft\\IdeaProjects\\PEYK_Yeni\\Ali Boz-87197540786.pdf");
        BrowserUtils.waitFor(2);

        peyk_pages.dokumanlariYukle.click();
        BrowserUtils.waitFor(2);
        peyk_pages.checkBox.click();
        BrowserUtils.waitFor(2);

        peyk_pages.imzalaGonder.click();
        BrowserUtils.waitFor(2);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",peyk_pages.kayitSayisi);
        BrowserUtils.waitFor(2);

        try {
            String pin = peyk_pages.pin.getText();
            BrowserUtils.waitFor(2);

            if (pin.contains("P")) {
                peyk_pages.eImzaPassword.click();
                peyk_pages.eImzaPassword.sendKeys("3944");
                BrowserUtils.waitFor(2);
            }
        }catch (Exception e){
            System.out.println("E-imza bulunmamaktadır!");
        }

        peyk_pages.imzala.click();
        BrowserUtils.waitFor(2);
        peyk_pages.evet.click();
        BrowserUtils.waitFor(5);
        Assert.assertEquals(peyk_pages.bilgi.getText(),"Bilgi");
        BrowserUtils.waitFor(2);
        peyk_pages.tamam.click();
        BrowserUtils.waitFor(1);

        peyk_pages.donemIslemleri.click();
        BrowserUtils.waitFor(2);
        String ucBordDonIslemText = peyk_pages.ucBordDonIslem.getText();
        Assert.assertEquals(ucBordDonIslemText, "Ücret Bordrosu Dönem İşlemleri");
        BrowserUtils.waitFor(3);

        peyk_pages.kullanici.click();
        peyk_pages.cikis.click();

        closeDriver();
    }
}
