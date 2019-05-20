package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPageObjects {

	@FindBy(xpath="//h2[text()='Add User Details']")
	public static WebElement addUserHeaderLabel;
}
