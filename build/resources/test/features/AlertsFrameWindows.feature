@modulosExtraerIngresar
Feature: Como usuario del portal demoqa
  quiero acceder al modulo alerts y practice form
  para extraer e ingresar informacion

  @extraer
  Scenario Outline: Extraer la informacion e ingresarla al reporte
    Given Ingreso al portal demoqa
    When Ingreso con el usuario "<usuario>" "<contrasena>"
    And Ingreso al modulo Alerts, Frame y Windows
    Then Puedo capturar los textos "<texto1>" "<texto2>"
    Examples:
    | usuario | contrasena | texto1        | texto2       |
    | test02  | Test2023*  | Parent frame  | Child Iframe |

  @Ingresar
  Scenario Outline: Ingresar la informacion en el modulo Practice Form
    Given Ingreso al portal demoqa
    When Ingreso con el usuario "<usuario>" "<contrasena>"
    And En el modulo Practice Form, ingresar la siguiente informacion "<firstName>" "<lastName>" "<email>" "<gender>" "<mobile>" "<birth>" "<subjects>" "<hobbies>" "<address>" "<state>" "<city>"
    Then Validar que se haya ingresado correctamente la informacion
    Examples:
    | usuario | contrasena | firstName | lastName | email              | gender | mobile    | birth             | subjects  | hobbies | address                    | state   | city   |
    | test02  | Test2023*  | Prueba01  | Prueba01 | prueba@yopmail.com | Female | 3004441234| 27 September 2000 | Commerce  | Music   | Autopista Norte al oriente | NCR     | Delhi  |


  @eliminarCuenta2
  Scenario Outline: Eliminar la cuenta
    Given Ingreso al portal demoqa
    When Ingreso con el usuario "<usuario>" "<contrasena>"
    And Ingresar al modulo Book Store Application y eliminar la cuenta
    Then Validar que la cuenta se haya eliminado ingresando al portal con los datos "<usuario>" "<contrasena>"
    Examples:
      | usuario | contrasena |
      | test02  | Test2023*  |