package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LibrosPage;

public class LibrosDefinition {

    LibrosPage librosPage;

    @Given("Ingreso al portal demoqa")
    public void ingresoAlPortalDemoqa() {
        librosPage.ingresoAlPortalDemoqa();
    }

    @When("Me registro en el portal con los datos {string} {string} {string} {string}")
    public void meRegistroEnElPortalConLosDatos(String nombres, String apellidos, String usuario, String contrasena) throws InterruptedException {
        librosPage.meRegistroEnElPortalConLosDatos(nombres, apellidos, usuario, contrasena);
    }

    @When("Selecciono el libro {string} y lo agrego a la coleccion")
    public void seleccionoElLibroYLoAgregoALaColeccion(String libro) throws InterruptedException {
        librosPage.seleccionoElLibroYLoAgregoALaColeccion(libro);
    }

    @Then("Verifico que los libros {string} {string} se hayan agregado correctamente")
    public void verificoQueLosLibrosSeHayanAgregadoCorrectamente(String libro1, String libro2) {
        librosPage.verificoQueLosLibrosSeHayanAgregadoCorrectamente(libro1, libro2);
    }

    @When("Ingreso con el usuario {string} {string}")
    public void ingresoConElUsuario(String usuario, String contrasena) {
        librosPage.ingresoConElUsuario(usuario, contrasena);
    }

    @When("Ingresar en el modulo profile y eliminar el libro {string}")
    public void ingresarEnElModuloProfileYElimnarElLibro(String libro) {
        librosPage.ingresarEnElModuloProfileYElimnarElLibro(libro);
    }

    @Then("Validar que el libro {string} se haya eliminado correctamente")
    public void validarQueElLibroSeHayaEliminadoCorrectamente(String libro) {
        librosPage.validarQueElLibroSeHayaEliminadoCorrectamente(libro);
    }

    @When("Ingresar al modulo Book Store Application y eliminar la cuenta")
    public void ingresarAlModuloBookStoreApplicationYEliminarLaCuenta() {
        librosPage.ingresarAlModuloBookStoreApplicationYEliminarLaCuenta();
    }

    @Then("Validar que la cuenta se haya eliminado ingresando al portal con los datos {string} {string}")
    public void validarQueLaCuentaSeHayaEliminadoIngresandoAlPortalConLosDatos(String usuario, String contrasena) {
        librosPage.validarQueLaCuentaSeHayaEliminadoIngresandoAlPortalConLosDatos(usuario, contrasena);
    }

}
