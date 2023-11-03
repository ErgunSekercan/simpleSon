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

    @Eğerki(": Ana sayfayı test etmek isterseniz")
    public void anaSayfa() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);
        peyk_pages.TcNo.sendKeys("admin_004329");
        peyk_pages.sifre.sendKeys("Ab,12345");
        peyk_pages.giris.click();
        BrowserUtils.waitFor(5);

        peyk_pages.anaSayfa.click();
        String anaSayfa = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(anaSayfa, "https://peyktest.kolaysoft.com.tr/accounting/peyk/hr-dashboard");
        BrowserUtils.waitFor(3);

        //Bordro
        peyk_pages.bordroGonder.click();
        BrowserUtils.waitFor(3);
        String bordroYukle = peyk_pages.ucretBordrosuYuk.getText();
        Assert.assertEquals(bordroYukle,"Ücret Bordrosu Yükle");
        BrowserUtils.waitFor(3);

        //Form
        peyk_pages.anaSayfa.click();
        BrowserUtils.waitFor(3);
        peyk_pages.formGonder.click();
        String formSablon = peyk_pages.sablonsuzGonderim.getText();
        Assert.assertEquals(formSablon,"Şablonsuz Gönderim");
        BrowserUtils.waitFor(3);

        //Taslak Hazırla
        peyk_pages.anaSayfa.click();
        BrowserUtils.waitFor(3);
        peyk_pages.taslakHazırla.click();
        String form = peyk_pages.formuOnizle.getText();
        Assert.assertEquals(form,"Formu Önizle");
        BrowserUtils.waitFor(3);

        //Aylık Bildirimler-Bordro Arşiv
        peyk_pages.anaSayfa.click();
        BrowserUtils.waitFor(3);
        peyk_pages.bordro.click();
        String ozlukBordrolar = peyk_pages.ozlukBordrolarArsiv.getText();
        Assert.assertEquals(ozlukBordrolar, "Ücret Bordroları Arşiv");
        BrowserUtils.waitFor(3);

        //Aylık Bildirimler-Formlar Arşiv
        peyk_pages.anaSayfa.click();
        BrowserUtils.waitFor(3);
        peyk_pages.form.click();
        String formlar = peyk_pages.formlarArsiv.getText();
        Assert.assertEquals(formlar, "Formlar Arşiv");
        BrowserUtils.waitFor(5);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": Onay Bekleyenleri test etmek isterseniz")
    public void onay_bekleyenleri_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.onayBekleyenler.click();
        String onayBek = peyk_pages.onayBekleyenler.getText();
        Assert.assertEquals(onayBek,"Onay Bekleyenler");
        BrowserUtils.waitFor(3);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": PEYK sekmesinin altındaki uygulamaları test etmek isterseniz")
    public void peyk_sekmesinin_altındaki_uygulamaları_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);
        String tanim = peyk_pages.tanimlar.getText();
        Assert.assertEquals(tanim,"Tanımlar");
        BrowserUtils.waitFor(2);

        //Tanımlar
        peyk_pages.tanimlar.click();
        BrowserUtils.waitFor(2);
        String departman = peyk_pages.departmanTanimi.getText();
        Assert.assertEquals(departman,"Departman Tanımı");
        BrowserUtils.waitFor(2);

        //Departman Tanımı
        peyk_pages.departmanTanimi.click();
        BrowserUtils.waitFor(2);
        String departList = peyk_pages.departmanListesi.getText();
        Assert.assertEquals(departList,"Departman Listesi");
        BrowserUtils.waitFor(2);

        //Departman Tür Tanımı
        peyk_pages.departmanTurTanimi.click();
        BrowserUtils.waitFor(2);
        String depturu = peyk_pages.departmanTuru.getText();
        Assert.assertEquals(depturu,"Departman Türü Listesi");
        BrowserUtils.waitFor(2);

        //Çalışan Tanımları
        peyk_pages.calisanTanimlari.click();
        BrowserUtils.waitFor(2);
        String calisanlar = peyk_pages.calisanlar.getText();
        Assert.assertEquals(calisanlar,"Çalışanlar");
        BrowserUtils.waitFor(2);

        //Çalışanlar
        peyk_pages.calisanlar.click();
        BrowserUtils.waitFor(2);
        String calisanListesi = peyk_pages.calisanListesi.getText();
        Assert.assertEquals(calisanListesi,"Çalışan Listesi");
        BrowserUtils.waitFor(2);

        //Çalışan Şifre Yönetimi
        peyk_pages.calisanSifreYon.click();
        BrowserUtils.waitFor(2);
        String calisanSifreYonetimi = peyk_pages.calSifYon.getText();
        Assert.assertEquals(calisanSifreYonetimi,"Çalışan Şifre Yönetimi");
        BrowserUtils.waitFor(2);

        //Firma Bilgileri
        peyk_pages.firmaBilgileri.click();
        BrowserUtils.waitFor(2);
        String logoYukle = peyk_pages.logoYukle.getText();
        Assert.assertEquals(logoYukle,"Logo Yükle");
        BrowserUtils.waitFor(2);

        //Bilgilendirme Durumu
        peyk_pages.bilgilendirmeDurumu.click();
        BrowserUtils.waitFor(2);
        String calisanBilgilendirmeList = peyk_pages.calisanBilgilendirmeList.getText();
        Assert.assertEquals(calisanBilgilendirmeList,"Çalışan Listesi");
        BrowserUtils.waitFor(2);

        //Onay Akışı
        peyk_pages.onayAkisi.click();
        BrowserUtils.waitFor(2);
        String yeniOnayAkisi = peyk_pages.yeniOnayAkisi.getText();
        Assert.assertEquals(yeniOnayAkisi,"Yeni Oluştur");
        BrowserUtils.waitFor(2);

        //e-imza Doğrulama
        peyk_pages.eImzaDog.click();
        BrowserUtils.waitFor(2);
        String eImzaDogrulama = peyk_pages.AkilliKart.getText();
        Assert.assertEquals(eImzaDogrulama,"Akıllı kart markası");
        BrowserUtils.waitFor(2);

        //Form Tanımları
        peyk_pages.formTanimlari.click();
        BrowserUtils.waitFor(2);
        String formSablonlari = peyk_pages.formSablonlari.getText();
        Assert.assertEquals(formSablonlari,"Form Şablonları");
        BrowserUtils.waitFor(2);

        //Form Şablonları
        peyk_pages.formSablonlari.click();
        BrowserUtils.waitFor(2);
        String formSablon = peyk_pages.formSablon.getText();
        Assert.assertEquals(formSablon,"Form Şablonları");
        BrowserUtils.waitFor(2);

        //Form Türü Tanımı
        peyk_pages.formTuruTanimi.click();
        BrowserUtils.waitFor(2);
        String eImzaDogrula = peyk_pages.formTuruListesi.getText();
        Assert.assertEquals(eImzaDogrula,"Form Türü Listesi");
        BrowserUtils.waitFor(4);

        //Firma Parametreleri
        peyk_pages.firmaParametreleri.click();
        BrowserUtils.waitFor(2);
        String firmaParam = peyk_pages.firmaParam.getText();
        Assert.assertEquals(firmaParam,"Firma Parametreleri");
        BrowserUtils.waitFor(2);

        //Talep Form Editör
        peyk_pages.talepFormEditor.click();
        BrowserUtils.waitFor(2);
        String talepFormlari = peyk_pages.talepFormlari.getText();
        Assert.assertEquals(talepFormlari,"Talep Formları");
        BrowserUtils.waitFor(2);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": Ücret Bordrosu özelliğini test etmek isterseniz")
    public void bordro(){

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        /*peyk_pages.TcNo.sendKeys("admin_004329");
        peyk_pages.sifre.sendKeys("Ab,12345");
        peyk_pages.giris.click();*/
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

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();

        closeDriver();
    }
    @Eğerki(": Form sekmesini test etmek isterseniz")
    public void form_sekmesini_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);

        peyk_pages.Form.click();
        BrowserUtils.waitFor(2);
        String formGonder = peyk_pages.formGonder.getText();
        Assert.assertEquals(formGonder,"Form Gönder");
        BrowserUtils.waitFor(2);

        peyk_pages.formGonder.click();
        BrowserUtils.waitFor(2);
        String formGon = peyk_pages.formGon.getText();
        Assert.assertEquals(formGon,"Form Gönder");
        BrowserUtils.waitFor(2);

        peyk_pages.formIslemleri.click();
        BrowserUtils.waitFor(2);
        String topluformGonder = peyk_pages.topluFormGonder.getText();
        Assert.assertEquals(topluformGonder,"Toplu Form Gönder");
        BrowserUtils.waitFor(2);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": Özlük işlemleri sekmesini test etmek isterseniz")
    public void özlük_işlemleri_sekmesini_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);

        peyk_pages.OzlukIslemleri.click();
        BrowserUtils.waitFor(2);
        String ozlukFormOnay = peyk_pages.ozlukFormOnay.getText();
        Assert.assertEquals(ozlukFormOnay,"Özlük Form Onay");
        BrowserUtils.waitFor(2);

        peyk_pages.ozlukFormOnay.click();
        BrowserUtils.waitFor(2);
        String ozlukArsiv = peyk_pages.ozlukArsiv.getText();
        Assert.assertEquals(ozlukArsiv,"Özlük Arşiv");
        BrowserUtils.waitFor(2);

        peyk_pages.ozlukDosyalari.click();
        BrowserUtils.waitFor(2);
        String ozlukIndir = peyk_pages.ozlukIndir.getText();
        Assert.assertEquals(ozlukIndir,"Özlük İndir");
        BrowserUtils.waitFor(2);
        closeDriver();
    }
    @Eğerki(": Arşivler sekmesini test etmek isterseniz")
    public void arşivler_sekmesini_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);

        peyk_pages.arsivler.click();
        BrowserUtils.waitFor(2);
        String ucretBordrolarıArsiv = peyk_pages.ucretBordrolariArsiv.getText();
        Assert.assertEquals(ucretBordrolarıArsiv,"Ücret Bordroları Arşiv");
        BrowserUtils.waitFor(2);

        peyk_pages.ucretBordrolariArsiv.click();
        BrowserUtils.waitFor(2);
        String ucretBordArs = peyk_pages.ucretBordArs.getText();
        Assert.assertEquals(ucretBordArs,"Ücret Bordroları Arşiv");
        BrowserUtils.waitFor(2);

        peyk_pages.formlarArs.click();
        BrowserUtils.waitFor(2);
        String formArs = peyk_pages.formArs.getText();
        Assert.assertEquals(formArs,"Formlar Arşiv");
        BrowserUtils.waitFor(2);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": Rol işlemleri sekmesini test etmek isterseniz")
    public void rol_işlemleri_sekmesini_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);

        peyk_pages.rolIslemleri.click();
        BrowserUtils.waitFor(2);
        String rolIslemleri = peyk_pages.rolOlusturma.getText();
        Assert.assertEquals(rolIslemleri,"Rol Oluşturma");
        BrowserUtils.waitFor(2);

        peyk_pages.rolOlusturma.click();
        BrowserUtils.waitFor(2);
        String rolListesi = peyk_pages.rolListesi.getText();
        Assert.assertEquals(rolListesi,"Rol Listesi");
        BrowserUtils.waitFor(2);

        peyk_pages.rolAtama.click();
        BrowserUtils.waitFor(2);
        String personelListesi = peyk_pages.personelListesi.getText();
        Assert.assertEquals(personelListesi,"Personel Listesi");
        BrowserUtils.waitFor(2);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": İşlem geçmişi sekmesini test etmek isterseniz")
    public void i̇şlem_geçmişi_sekmesini_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.PEYK.click();
        BrowserUtils.waitFor(2);

        peyk_pages.islemGecmisi.click();
        BrowserUtils.waitFor(2);
        String islemGecmisi = peyk_pages.isGec.getText();
        Assert.assertEquals(islemGecmisi,"İşlem Geçmişi");
        BrowserUtils.waitFor(2);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }
    @Eğerki(": Vekil yetkilendirme sekmesini test etmek isterseniz")
    public void vekil_yetkilendirme_sekmesini_test_etmek_isterseniz() {

        Driver.getDriver().get("https://peyktest.kolaysoft.com.tr/accounting/login");
        BrowserUtils.waitFor(5);

        peyk_pages.vekilYetkilendirme.click();
        BrowserUtils.waitFor(2);
        String islemGecmisi = peyk_pages.vekilYet.getText();
        Assert.assertEquals(islemGecmisi,"Vekil Yetkilendirme");
        BrowserUtils.waitFor(3);

        //peyk_pages.kullanici.click();
        //peyk_pages.cikis.click();
        closeDriver();
    }


}
