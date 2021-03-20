Feature: When.Do

  @TALLER03
  Scenario: Como usuario del aplicativo When.Do
            Quiero poder agregar una tarea
            Y tambien poder eliminarla
            Para poder llevar un registro de actividades

    Given yo tengo abierto el aplicativo When.Do
    When yo agrego una tarea
    And yo elimino una tarea
    Then el resultado no debe mostrar ninguna tarea existente