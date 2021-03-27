package runner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import whenDo.MainScreen;
import whenDo.NewNotes;

import java.net.MalformedURLException;

public class MyStepdefs {

    MainScreen mainScreen= new MainScreen();
    NewNotes newNotesScrenn= new NewNotes();

    @Given("yo tengo abierto el aplicativo When.Do")
    public void yoTengoAbiertoElAplicativoWhenDo()  {
    }

    @When("yo {} una tarea")
    public void yoAgregoUnaTarea(String accion) throws MalformedURLException, InterruptedException {

        if (accion.equals("agrego")) {
            String titulo = "TallerFinal";
            String nota = "nota";

            mainScreen.addContact.click();
            newNotesScrenn.titleTxtBox.setText(titulo);
            newNotesScrenn.noteTxtBox.setText(nota);
            newNotesScrenn.saveButton.click();

        } else {
            //eliminar Tarea

            mainScreen.check.click();
            mainScreen.menu_eli.click();
            mainScreen.eliminar.click();
            mainScreen.confirmar.click();
        }
    }

    @Then("el resultado no debe mostrar ninguna tarea existente")
    public void elResultadoNoDebeMostrarNingunaTareaExistente() throws MalformedURLException {

        String noTareas = "No se agregaron tareas";
        String actualResult = mainScreen.labelEliminar.getText();
        Assert.assertEquals("EL resultado es incorrecto",noTareas, actualResult);
    }
}

