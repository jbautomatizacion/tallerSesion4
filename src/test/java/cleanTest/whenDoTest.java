package cleanTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import singletonSession.Session;
import whenDo.MainScreen;
import whenDo.NewNotes;

import java.net.MalformedURLException;

public class whenDoTest {

    MainScreen mainScreen= new MainScreen();
    NewNotes newNotesScrenn= new NewNotes();

    @Test
    public void createNewNote() throws MalformedURLException, InterruptedException {

        String titulo = "TallerFinal";
        String nota = "nota";

        mainScreen.addContact.click();
        newNotesScrenn.titleTxtBox.setText(titulo);
        newNotesScrenn.noteTxtBox.setText(nota);
        newNotesScrenn.saveButton.click();

        Assert.assertTrue("ERROR no fue creado",mainScreen.isDispledTitle("TallerFinal"));

        String actualResultTitulo = mainScreen.labelTitulo.getText();
        String actualResultNota = mainScreen.labelNota.getText();

        Assert.assertEquals("El resultado es incorrecto",titulo,actualResultTitulo);
        Assert.assertEquals("El resultado es incorrecto",nota,actualResultNota);

        //eliminar Tarea

        String noTareas = "No se agregaron tareas";

        mainScreen.check.click();
        Thread.sleep(2000);
        mainScreen.menu_eli.click();
        mainScreen.eliminar.click();
        mainScreen.confirmar.click();

        String actualResult = mainScreen.labelEliminar.getText();

        Assert.assertEquals("EL resultado es incorrecto",noTareas, actualResult);
    }

    @After
    public void after() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
