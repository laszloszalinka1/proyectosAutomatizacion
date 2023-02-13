package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.LoginPage;
import pages.ProductsPage;

public class CrearProductoPage {
    LoginPage login = new LoginPage();
    ProductsPage product = new ProductsPage();
    private  String producto = "sprink";

    @Given("^el usuario se encuentra en la pantalla de productos$")
    public void irAProductos(){
        login.irArange();
        login.login();
        product.goToProductPage();
    }
    @And("^el usuario da clic en el boton Add new$")
    public void agregarProducto(){
        product.botonAddNew();
    }
    @Then("^el usuario llena la informacion solicitada y da clic en el boton Save$")
    public void llenarFormulario(){
        product.llenarData(producto, "gaseosa deliciosa");
        
    }
    @Given("^el usuario puede validar el producto creado$")
    public void validarProducto(){
        System.out.println("el mensaje es :" +product.validarMensajeProdCreado());
        Assert.assertEquals("\u00d7\n" +
                "The new product has been added successfully.", product.validarMensajeProdCreado());
        
        product.buscarProdCreado(producto);
        Assert.assertEquals(producto, product.validarProd(producto));
        login.logout();
    }
    
    
}
