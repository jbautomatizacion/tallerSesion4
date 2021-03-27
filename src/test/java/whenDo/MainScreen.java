package whenDo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MainScreen {

    public Button addContact = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public Button check = new Button(By.id("com.vrproductiveapps.whendo:id/home_list_item_marked"));
    public Button menu_eli = new Button(By.xpath("//android.widget.ImageView[contains(@content-desc,'opciones')]"));
    public Button eliminar = new Button(By.xpath("//android.widget.TextView[contains(@text,'Elimi')]"));
    public Button confirmar = new Button(By.id("android:id/button1"));

    public Label labelTitulo = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public Label labelNota = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text2"));
    public Label labelEliminar = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));

    public MainScreen(){}

    public boolean isDispledTitle(String title){
        Label titleContact= new Label(By.xpath("//android.widget.TextView[@text='"+title+"']"));
        return titleContact.isControlDisplayed();
    }
}
