package MenuOrHeaderPanelTest;

import java.io.IOException;

import LoginModuleTest.LoginpageTest;
import MenuOrHeaderPanel.MenuOrHeaderPanel;

public class MenuOrHeaderPanelTest extends LoginpageTest
{

	public MenuOrHeaderPanelTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	MenuOrHeaderPanel menuHeaderPanel = new MenuOrHeaderPanel();
	
	//@Test
	public void clickOnInnoPlusHeaderMenu() throws Exception
	{
		menuHeaderPanel.openInnovationFromPlusMenuFromHeader();
	}
	
	//@Test
	public void clickOnPlusHeaderMenu() throws Exception
	{
		menuHeaderPanel.openEngFromPlusMenuFromHeader();
	}
}
