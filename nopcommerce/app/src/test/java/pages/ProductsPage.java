package pages;

import org.openqa.selenium.StaleElementReferenceException;

public class ProductsPage extends BasePage {
    private String btnAdd = "//a[@class='btn btn-primary']";
    private String nombre = "//*[@id='Name']";
    private String description = "//*[@id='ShortDescription']";
    private String save = "//*[@name='save']";
    private String mensajeProductoAgregado = "//*[@class='alert alert-success alert-dismissable']";
    private String productName = "//*[@id='SearchProductName']";
    private String btnSearch = "//*[@id='search-products']";
    private String btnEditar = "//*[@class='btn btn-default']";
    private String selfirt = "//input[@value='1']";
    private String btnEliminar = "//*[@id='delete-selected']";
    private String btnYes ="//*[@id='delete-selected-action-confirmation-submit-button']";
    private String noDataAviable = "//*[contains(text(),'No data available in table')]";

    public ProductsPage(){
        super(driver);
    }
    public void goToProductPage(){
        String[] ruta = {"//*[contains(text(),'Catalog')]","//*[contains(text(),'Products')]"};
        goToPage(ruta);
    }
    public void botonAddNew(){
        clickElement(btnAdd);
    }
    public void llenarData(String nombre, String desc){
        write(this.nombre, nombre);
        write(description, desc);
        clickElement(save);
    }
    public String validarMensajeProdCreado(){
       return textFromElement(mensajeProductoAgregado);
    }
    public void buscarProdCreado(String prod){
        write(productName, prod);
        clickElement(btnSearch);
        scrollDown("window.scrollBy(0,500)");
        
    }
    public String validarProd(String objeto){
        return textFromElement("//td[text()='"+objeto+"']");
    }
    public void btnEditar(){
        try {
            clickElement(btnEditar);
        }catch (StaleElementReferenceException e){
            clickElement(btnEditar);

        }
    }
    public void eliminarProducto(){
        try{
        clicElementFromTable("//*[@id='products-grid_wrapper']/div[1]/div/div/div[2]", 1, 1);
        clickElement(btnEliminar);
        clickElement(btnYes);
         }catch (StaleElementReferenceException e){
            clickElement(btnYes);

        }
    }
    public String validarProdElim(){
        return textFromElement(noDataAviable);
    }
}
