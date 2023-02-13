package steps;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pages.LoginPage;
import pages.ProductsPage;

public class EliminarProductoSteps {
    LoginPage login = new LoginPage();
    ProductsPage product = new ProductsPage();
    private  String producto = "sprink";

    
    @When("^el usuario selecciona el producto modificado previamente$")
    public void selProdModificado(){
        product.buscarProdCreado(producto);
        product.validarProd(producto+"Modificado");
    }
    @And("^el usuario da clic en el boton delete$")
    public void eliminarProd(){
        product.eliminarProducto();
    }
    @Given("^el usuario valida que no se muestre el producto que fue eliminado$")
    public void validarProdEliminado(){
        Assert.assertEquals("No data available in table", product.validarProdElim());
    }
}
