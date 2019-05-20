package page.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.common.utils.CommonActions;

import page.objects.AddUserPageObjects;
import page.objects.DashBoardPageObjects;

public class DashBoardPageSteps extends HomePageSteps{
	
	@Test(dependsOnGroups= {"group1"}, priority=2)
	public void GetNumberofUsers() {
		
		PageFactory.initElements(driver, DashBoardPageObjects.class);
		int sizee =DashBoardPageObjects.numberOfUsersLabel.size();
		System.out.println(sizee);
		for(WebElement ele: DashBoardPageObjects.numberOfUsersLabel) {
			System.out.println(ele.getText());
		}
		Assert.assertEquals(6, 6);
	}

	@Test(dependsOnGroups= {"group1"},priority=3)
	public void AddUserCheck() {
		PageFactory.initElements(driver, AddUserPageObjects.class);
		ClickButton(driver, DashBoardPageObjects.addUsersLink);
		String addUserHeaderLabel = AddUserPageObjects.addUserHeaderLabel.getText();
		Assert.assertEquals(addUserHeaderLabel, "Add User Details");
		
	}
}
