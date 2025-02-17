package MentorPanelTest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import utils.Testutils;
import MentorPanel.Themes;

public class ThemesTest extends TestBase{

	Themes themes;

	public ThemesTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void setup() throws IOException {
		super.initialization();
		themes = new Themes();
		Testutils.ValidateUserLogin();
	}

	@Test(priority = 1)
	public void Verify_navigatetothemes_functionality() throws InterruptedException {
		themes.navigate_to_themes();
	}

	@Test(priority = 2)
	public void Verify_buttons_mandatoryfields() throws InterruptedException {
		themes.buttons_mandatoryfields();
	}

	@Test(priority = 3)
	public void verify_addthemes_functionality() throws InterruptedException {
		themes.adddetails();

	}

	@Test(priority = 4)
	public void verify_toggle_functionality() throws InterruptedException {
		themes.toggleactions();

	}

	@Test(priority = 5)
	public void verify_pagination_functionality() throws InterruptedException {
		themes.pagination();
	}

	@Test(priority = 6)
	public void verify_edit_functionality() throws InterruptedException {
		themes.editpage();

	}

	@Test(priority = 7)
	public void verify_search_functionality() throws InterruptedException {
		themes.searchbar();

	}
	
	@Test(priority = 8)
	public void verify_view_functionality() throws InterruptedException {
		themes.viewpage();

	}

}
