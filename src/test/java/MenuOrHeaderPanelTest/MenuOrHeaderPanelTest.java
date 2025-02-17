package MenuOrHeaderPanelTest;

import java.io.IOException;

import org.testng.annotations.Test;

import LoginModuleTest.LoginpageTest;
import MenuOrHeaderPanel.MenuOrHeaderPanel;

public class MenuOrHeaderPanelTest extends LoginpageTest
{

	public MenuOrHeaderPanelTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	MenuOrHeaderPanel menuHeaderPanel = new MenuOrHeaderPanel();
	
	@Test
	public void clickOnPlusHeaderMenu() throws Exception
	{
		menuHeaderPanel.openPlusMenuFromHeader();
	}
}
