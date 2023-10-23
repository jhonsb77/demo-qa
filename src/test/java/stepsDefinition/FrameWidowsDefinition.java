package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.FrameWindowsPage;

public class FrameWidowsDefinition {

    FrameWindowsPage frameWindowsPage;

    @And("Ingreso al modulo Alerts, Frame y Windows")
    public void ingresoAlModuloAlertsFrameYWindows() {
        frameWindowsPage.ingresoAlModuloAlertsFrameYWindows();
    }
    @Then("Puedo capturar los textos {string} {string}")
    public void puedoCapturarLosTextos(String texto1, String texto2) {
        frameWindowsPage.puedoCapturarLosTextos(texto1, texto2);
    }

    @And("En el modulo Practice Form, ingresar la siguiente informacion {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void enElModuloPracticeFormIngresarLaSiguienteInformacion(String firstName, String lastName
            , String email, String gender, String mobile, String birth, String subjects, String hobbies
            , String address, String state, String city) {

        frameWindowsPage.enElModuloPracticeFormIngresarLaSiguienteInformacion(firstName, lastName, email
                , gender, mobile, birth, subjects, hobbies, address, state, city);
    }

    @Then("Validar que se haya ingresado correctamente la informacion")
    public void validarQueSeHayaIngresadoCorrectamenteLaInformacion() {
        frameWindowsPage.validarQueSeHayaIngresadoCorrectamenteLaInformacion();
    }
}
