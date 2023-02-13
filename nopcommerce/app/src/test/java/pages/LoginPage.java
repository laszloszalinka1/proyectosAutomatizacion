package pages;

public class LoginPage extends BasePage{

public String btnLogin = "//button[contains(text(),'Log in')]";
public String btnLogout = "//*[contains(text(),'Logout')]";
    public LoginPage(){
        super(driver);
        
    }

public void irArange(){
    navigateTo("https://admin-demo.nopcommerce.com/login");
}

public void login(){
    
    clickElement(btnLogin);
}
public void logout(){
    clickElement(btnLogout);
}
    
}
