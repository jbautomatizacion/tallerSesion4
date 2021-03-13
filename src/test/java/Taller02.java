import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;


public class Taller02 {
    
    private AppiumDriver driver;

    @Before
    public void beforeTest() throws MalformedURLException {

        //configuracion conexion
        DesiredCapabilities capacibilites = new DesiredCapabilities();
        capacibilites.setCapability("deviceName","MI 9");
        capacibilites.setCapability("platformVersion","10");
        capacibilites.setCapability("appPackage","com.vrproductiveapps.whendo");
        capacibilites.setCapability("appActivity", ".ui.HomeActivity");
        capacibilites.setCapability("platformName", "Android");

        //driver apunte a nuestro appiumDesktop
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacibilites);

        //implicit:
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void agregarTarea(){

        String titulo = "PruebaTaller02";
        String nota = "Item02";
        String puntos = "Más opciones";

        byte[] ptext = puntos.getBytes(ISO_8859_1);
        String value = new String(ptext, UTF_8);

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(nota);
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        String actualResultTitulo = driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();
        String actualResultNota = driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text2")).getText();

        Assert.assertEquals("El resultado es incorrecto",titulo,actualResultTitulo);
        Assert.assertEquals("El resultado es incorrecto",nota,actualResultNota);

        //eliminar Tarea

        String noTareas = "No se agregaron tareas";

        driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_marked")).click();
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='"+value+"']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Elimi')]")).click();
        driver.findElement(By.id("android:id/button1")).click();

        String actualResult = driver.findElement(By.id("com.vrproductiveapps.whendo:id/noNotesText")).getText();

        Assert.assertEquals("EL resultado es incorrecto",noTareas, actualResult);
    }

    
    @After
    public void after(){
        driver.quit();
    }


}
