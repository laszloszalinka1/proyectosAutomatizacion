package steps;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;

public class ModificarPorductoSteps {
    LoginPage login = new LoginPage();
    ProductsPage product = new ProductsPage();
    private  String producto = "sprink";
    
    @When("^el usuario filtra un producto y da clic en edit$")
    public void filtraProdYEdit(){
        product.buscarProdCreado(producto);
        Assert.assertEquals(producto, product.validarProd(producto));
        product.btnEditar();

    }
    @Given("^el usuario modifica el nombre y da clic en save$")
    public void  modificarProd(){
        product.llenarData(producto+"Modificado","descModificado");
    }
    @Given("^el usuario valida que se haya modificado correctamente$")
    public void validarModificacion(){
        System.out.println("el mensaje es :" +product.validarMensajeProdCreado());
        Assert.assertEquals("\u00d7\n" +
                "The product has been updated successfully.", product.validarMensajeProdCreado());

        product.buscarProdCreado(producto+"Modificado");
        Assert.assertEquals(producto+"Modificado", product.validarProd(producto+"Modificado"));
        login.logout();
    }
}
