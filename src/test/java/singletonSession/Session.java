package singletonSession;

import factoryDevices.FactoryDevices;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class Session {

    // atributo del mismo tipo de la clase
    private static Session mySession = null;
    private AppiumDriver driver;

    // constructor debe ser privado
    private Session() throws MalformedURLException {
        driver = FactoryDevices.make(FactoryDevices.ANDROID).create();
    }

    //metodo estatico para determinar la creacion del atributo de la clase
    public static Session getInstance() throws MalformedURLException {
        if (mySession == null)
            mySession = new Session();

        return mySession;
    }

    public void closeSession(){
        driver.quit();
        mySession = null;
    }

    public AppiumDriver getDriver(){
        return driver;
    }

}
