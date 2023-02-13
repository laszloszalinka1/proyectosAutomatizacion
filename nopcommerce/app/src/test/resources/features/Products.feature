Feature: probar la funcionalidad de la pantalla productos

Background: usuario ya tiene la sesion activa
    Given el usuario se encuentra en la pantalla de productos

@producto
Scenario: el usuario va a crear un producto
    
    And el usuario da clic en el boton Add new
    When el usuario llena la informacion solicitada y da clic en el boton Save
    Then el usuario puede validar el producto creado
@producto
Scenario: Probar la funcionalidad de modificar producto
   
    When el usuario filtra un producto y da clic en edit
    And el usuario modifica el nombre y da clic en save
    Then el usuario valida que se haya modificado correctamente
@producto
Scenario: Eliminar producto modificado
    
    When  el usuario selecciona el producto modificado previamente
    And el usuario da clic en el boton delete
    Then el usuario valida que no se muestre el producto que fue eliminado