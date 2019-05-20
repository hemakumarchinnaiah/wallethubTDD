package page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPageObjects {
	// //*[text()='Add User']
	@FindBy(xpath="(//a[@class='dashboard-module']/img[1])[1]")
	public static WebElement dashBoardLink;

	@FindBy(id="logout")
	public static WebElement logOutLink;

	@FindBy(xpath="//div[@class='module-body']/p")
	public static List <WebElement>  numberOfUsersLabel;

	@FindBy(xpath="(//a[@class='dashboard-module']//img)[1]")
	public static WebElement addUsersLink;
	
}
