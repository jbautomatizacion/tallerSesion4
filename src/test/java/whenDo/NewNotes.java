package whenDo;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class NewNotes {

    public TextBox titleTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public NewNotes(){}
}
