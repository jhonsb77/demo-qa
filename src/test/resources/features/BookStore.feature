@creacionEliminacionLibros
Feature: Como usuario del portal demoqa
  deseo poder agregar y eliminar libros
  para visualizarlos en mi coleccion

  @agregarLibro
  Scenario Outline: Agregar libros a la coleccion
    Given Ingreso al portal demoqa
    When Ingreso con el usuario "<usuario>" "<contrasena>"
    And Selecciono el libro "<libro1>" y lo agrego a la coleccion
    And Selecciono el libro "<libro2>" y lo agrego a la coleccion
    Then Verifico que los libros "<libro1>" "<libro2>" se hayan agregado correctamente
    Examples:
     | usuario | contrasena | libro1                  | libro2                      |
     | test01  | Test2023*  | Programming JavaScript  | Understanding ECMAScript 6  |

  @eliminarLibro
  Scenario Outline: Eliminar libros de la coleccion
    Given Ingreso al portal demoqa
    When Ingreso con el usuario "<usuario>" "<contrasena>"
    And  Ingresar en el modulo profile y eliminar el libro "<libro>"
    Then Validar que el libro "<libro>" se haya eliminado correctamente
    Examples:
      | usuario | contrasena | libro                  |
      | test01  | Test2023*  | Programming JavaScript |

  @eliminarCuenta
  Scenario Outline: Eliminar la cuenta
    Given Ingreso al portal demoqa
    When Ingreso con el usuario "<usuario>" "<contrasena>"
    And Ingresar al modulo Book Store Application y eliminar la cuenta
    Then Validar que la cuenta se haya eliminado ingresando al portal con los datos "<usuario>" "<contrasena>"
    Examples:
      | usuario | contrasena |
      | test01  | Test2023*  |








