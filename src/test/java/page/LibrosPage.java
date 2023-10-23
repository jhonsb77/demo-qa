package page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import utils.Tools;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class LibrosPage extends Tools {


    @FindBy(id = "newUser")
    WebElementFacade btnNewUser;

    @FindBy(id = "firstname")
    WebElementFacade txtNombres;

    @FindBy(id = "lastname")
    WebElementFacade txtApellidos;

    @FindBy(id = "userName")
    WebElementFacade txtUser;

    @FindBy(id = "password")
    WebElementFacade txtContrasena;

    @FindBy(id = "login")
    WebElementFacade btnLogin;

    @FindBy(xpath = "//*[text()='Book Store']")
    WebElementFacade btnBookStore;

    @FindBy(xpath = "//*[text()='Add To Your Collection']")
    WebElementFacade btnAddColection;

    @FindBy(xpath = "//*[text()='Back To Book Store']")
    WebElementFacade btnBackBookStore;

    @FindBy(xpath = "//*[text()='Profile']")
    WebElementFacade btnProfile;

    @FindBy(xpath = "(//*[contains(text(),'Books')])[1]")
    WebElementFacade lblBooks;

    @FindBy(id = "closeSmallModal-ok")
    WebElementFacade btnDeleteOK;

    @FindBy(xpath = "//*[text()='Delete Account']")
    WebElementFacade btnDeleteAccount;

    @FindBy(xpath = "//*[text()='Log out']")
    WebElementFacade btnLogOut;

    @FindBy(xpath = "//*[text()='Invalid username or password!']")
    WebElementFacade lblInvalidUsername;

    public void ingresoAlPortalDemoqa() {
        open();
    }

    public void meRegistroEnElPortalConLosDatos(String nombres, String apellidos, String usuario, String contrasena) throws InterruptedException {
        scrollElement(btnNewUser);
        btnNewUser.click();
        explicitWait(txtNombres);
        txtNombres.sendKeys(nombres);
        txtApellidos.sendKeys(apellidos);
        scrollElement(txtUser);
        txtUser.sendKeys(usuario);
        txtContrasena.sendKeys(contrasena);
    }

    public void ingresoConElUsuario(String usuario, String contrasena) {
        explicitWait(txtUser);
        txtUser.sendKeys(usuario);
        txtContrasena.sendKeys(contrasena);
        scrollElement(btnLogin);
        btnLogin.click();
    }

    public void seleccionoElLibroYLoAgregoALaColeccion(String libro) throws InterruptedException {
        WebElementFacade btnLibro = find(By.xpath("//*[contains(text(),'"+libro+"')]"));
        scrollElement(btnBookStore);
        javaScriptClick(btnBookStore);
        scrollElement(btnLibro);
        btnLibro.click();
        scrollElement(btnAddColection);
        btnAddColection.click();
        System.out.println(validarAlerta());
        scrollElement(btnBackBookStore);
        btnBackBookStore.click();
    }

    public void verificoQueLosLibrosSeHayanAgregadoCorrectamente(String libro1, String libro2) {
        WebElementFacade btnLibro1 = find(By.xpath("//*[contains(text(),'"+libro1+"')]"));
        WebElementFacade btnLibro2 = find(By.xpath("//*[contains(text(),'"+libro2+"')]"));
        scrollElement(btnProfile);
        btnProfile.click();
        scrollElement(lblBooks);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertThat("el libro: "+libro1+" no se encuentra en la coleccion",btnLibro1.isPresent());
        assertThat("el libro: "+libro2+" no se encuentra en la coleccion",btnLibro2.isPresent());
    }



    public void ingresarEnElModuloProfileYElimnarElLibro(String libro) {
        WebElementFacade btnBorrarLibro =
                find(By.xpath("(//*[contains(text(),'"+libro+"')]//" +
                        "following::span[@id='delete-record-undefined'])[1]"));
        scrollElement(btnProfile);
        btnProfile.click();
        scrollElement(btnBorrarLibro);
        btnBorrarLibro.click();
        explicitWait(btnDeleteOK);
        btnDeleteOK.click();
        validarAlerta();
    }

    public void validarQueElLibroSeHayaEliminadoCorrectamente(String libro) {
        WebElementFacade btnLibro = find(By.xpath("//*[contains(text(),'"+libro+"')]"));
        scrollElement(btnProfile);
        btnProfile.click();
        scrollElement(lblBooks);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertThat("el libro: "+libro+" no se elimino de la coleccion",!btnLibro.isPresent());
    }

    public void ingresarAlModuloBookStoreApplicationYEliminarLaCuenta() {
        scrollElement(btnProfile);
        btnProfile.click();
        scrollElement(btnDeleteAccount);
        btnDeleteAccount.click();
        explicitWait(btnDeleteOK);
        btnDeleteOK.click();
    }

    public void validarQueLaCuentaSeHayaEliminadoIngresandoAlPortalConLosDatos(String usuario, String contrasena) {
        String textoAlerta = validarAlerta();
        Serenity.recordReportData().withTitle("Mensaje de alerta").andContents(textoAlerta);
        if(btnLogOut.isPresent()){
            btnLogOut.click();
        }
        ingresoConElUsuario(usuario,contrasena);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        assertThat("El usuario no se elimino ",lblInvalidUsername.isPresent());
    }

}
