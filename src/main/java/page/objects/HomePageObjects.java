package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {

	@FindBy(id="txtusername")
	public static WebElement userNameTextBox;

	@FindBy(name="txtpassword")
	public static WebElement passWordTextBox;

	@FindBy(name="submit")
	public static WebElement enterButton;

}
