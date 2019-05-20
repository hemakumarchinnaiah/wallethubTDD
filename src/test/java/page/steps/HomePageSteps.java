package page.steps;



import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.common.utils.CommonActions;
import com.test.common.utils.CommonUtils;

import page.objects.AddUserPageObjects;
import page.objects.DashBoardPageObjects;
import page.objects.HomePageObjects;

public class HomePageSteps extends CommonActions {


	@Test(groups = {"group1"},priority=1)
	public void VerifyLogin() {

		PageFactory.initElements(driver,HomePageObjects.class );
		PageFactory.initElements(driver,DashBoardPageObjects.class );

		try {
			SendKeys(driver, HomePageObjects.userNameTextBox,userName);
			SendKeys(driver, HomePageObjects.passWordTextBox,passWord);
			ClickButton(driver,HomePageObjects.enterButton);
			String LoginVerification = DashBoardPageObjects.logOutLink.getText();
			Assert.assertEquals(LoginVerification, "ut", "Login Success");

		}catch(WebDriverException ele){
			Assert.assertTrue(false, "Unable to verify login due to exception. " + ele);
		}
	}


}
