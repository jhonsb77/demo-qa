package page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.Tools;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class FrameWindowsPage extends Tools {

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']")
    WebElementFacade btnAlertsFrameWindows;

    @FindBy(xpath = "//*[text()='Nested Frames']")
    WebElementFacade btnNestedFrames;

    @FindBy(id = "frame1")
    WebElementFacade iframe;

    @FindBy(xpath = "//*[@srcdoc='<p>Child Iframe</p>']")
    WebElementFacade iframeChild;

    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']//..")
    WebElementFacade lblParentFrame;

    @FindBy(xpath = "/html/body/p")
    WebElementFacade lblChildFrame;

    @FindBy(xpath = "//*[text()='Forms']")
    WebElementFacade btnForms;

    @FindBy(xpath = "//*[text()='Practice Form']")
    WebElementFacade btnPracticeForm;

    @FindBy(id = "firstName")
    WebElementFacade txtFistName;

    @FindBy(id = "lastName")
    WebElementFacade txtLastName;

    @FindBy(id = "userEmail")
    WebElementFacade txtEmail;

    @FindBy(id = "userNumber")
    WebElementFacade txtNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElementFacade txtBirth;

    @FindBy(id = "subjectsInput")
    WebElementFacade txtSubjects;

    @FindBy(id = "currentAddress")
    WebElementFacade txtAddress;

    @FindBy(xpath = "//*[text()='Select State']")
    WebElementFacade btnSelectState;

    @FindBy(xpath = "//*[text()='Select City']")
    WebElementFacade btnSelectCiudad;

    @FindBy(id = "uploadPicture")
    WebElementFacade btnUploadPicture;

    @FindBy(id = "submit")
    WebElementFacade btnSubmit;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElementFacade lblTituloCompletado;

    public void ingresoAlModuloAlertsFrameYWindows() {
        scrollElement(btnAlertsFrameWindows);
        btnAlertsFrameWindows.click();
        scrollElement(btnNestedFrames);
        btnNestedFrames.click();
    }

    public void puedoCapturarLosTextos(String texto1, String texto2) {
        explicitWait(iframe);
        getDriver().switchTo().frame(iframe);
        Serenity.recordReportData().withTitle("texto iframe parent").andContents(lblParentFrame.getText());
        getDriver().switchTo().frame(iframeChild);
        Serenity.recordReportData().withTitle("texto iframe child").andContents(lblChildFrame.getText());
    }

    public void enElModuloPracticeFormIngresarLaSiguienteInformacion(String firstName, String lastName
            , String email, String gender, String mobile, String birth, String subjects, String hobbies
            , String address, String state, String city) {

        String[] nacimiento = birth.split(" ");
        WebElementFacade cmbGender = find(By.xpath("//*[@value='"+gender+"']"));
        WebElementFacade cmbHobbies = find(By.xpath("//*[text()='"+hobbies+"']"));
        WebElementFacade selectState = find(By.xpath("//*[text()='"+state+"']"));
        WebElementFacade selectCity = find(By.xpath("//*[text()='"+city+"']"));
        WebElementFacade selectSubject = find(By.id("react-select-2-option-0"));
        WebElementFacade btnDia =
                find(By.xpath("//*[contains(@class,'react-datepicker__day') and text()='"+nacimiento[0]+"']"));
        explicitWait(btnForms);
        btnForms.click();
        explicitWait(btnPracticeForm);
        btnPracticeForm.click();
        explicitWait(txtFistName);
        txtFistName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtEmail.sendKeys(email);
        javaScriptClick(cmbGender);
        txtNumber.sendKeys(mobile);
        scrollElement(txtBirth);
        txtBirth.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Select selectAnioNacimiento = new Select
                (getDriver().findElement(By.xpath("//*[@class='react-datepicker__year-select']")));
        selectAnioNacimiento.selectByVisibleText(nacimiento[2]);
        Select selectMesNacimiento = new Select
                (getDriver().findElement(By.xpath("//*[@class='react-datepicker__month-select']")));
        selectMesNacimiento.selectByVisibleText(nacimiento[1]);
        btnDia.click();
        txtSubjects.sendKeys(subjects);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        scrollElement(selectSubject);
        selectSubject.click();
        cmbHobbies.click();
        btnUploadPicture.sendKeys(System.getProperty("user.dir") + "\\img\\arcaxiareimods.png");
        txtAddress.sendKeys(address);
        scrollElement(btnSelectState);
        btnSelectState.click();
        javaScriptClick(selectState);
        btnSelectCiudad.click();
        javaScriptClick(selectCity);

    }

    public void validarQueSeHayaIngresadoCorrectamenteLaInformacion() {
        javaScriptClick(btnSubmit);
        try{
            explicitWait(lblTituloCompletado);
            assertThat("No se completo el formulario con exito",
                    lblTituloCompletado.getText().equals("Thanks for submitting the form"));
        }catch (Exception e){
            assertThat("No se completo el formulario con exito ",false);
        }

    }

}
