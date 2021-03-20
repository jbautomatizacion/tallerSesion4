package Runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class MyStepdefs {

    private AppiumDriver driver;
    @Given("yo tengo abierto el aplicativo When.Do")
    public void yoTengoAbiertoElAplicativoWhenDo() throws MalformedURLException {

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

    @When("yo {} una tarea")
    public void yoAgregoUnaTarea(String accion) {

        if (accion.equals("agrego")) {
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

            Assert.assertEquals("El resultado es incorrecto", titulo, actualResultTitulo);
            Assert.assertEquals("El resultado es incorrecto", nota, actualResultNota);

        } else {
            //eliminar Tarea
            String puntos = "Más opciones";
            String noTareas = "No se agregaron tareas";

            byte[] ptext = puntos.getBytes(ISO_8859_1);
            String value = new String(ptext, UTF_8);

            driver.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_marked")).click();
            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='" + value + "']")).click();
            driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Elimi')]")).click();
            driver.findElement(By.id("android:id/button1")).click();
        }
    }

    @Then("el resultado no debe mostrar ninguna tarea existente")
    public void elResultadoNoDebeMostrarNingunaTareaExistente() {

            String noTareas = "No se agregaron tareas";
            String actualResult = driver.findElement(By.id("com.vrproductiveapps.whendo:id/noNotesText")).getText();

            Assert.assertEquals("EL resultado es incorrecto",noTareas, actualResult);
        }
    }
