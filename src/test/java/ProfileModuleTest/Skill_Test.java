package ProfileModuleTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ProfilePages.Personal_Information;
import ProfilePages.Skill;
import base.TestBase;
import utils.Testutils;

public class Skill_Test extends TestBase {
	Personal_Information PI;
	Skill Sk;

	public Skill_Test() {
		super();
	}

	@BeforeClass
	public void setup() {
		super.initialization();
		Sk = new Skill();
		PI = new Personal_Information();
		Testutils.logindetails("chand.patel@tntra.io", "Brijesh@05042003");
	}

	@Test(priority = 1)
	public void navigatetoEducationthroughProfile() throws InterruptedException {
		PI.NavigatetoProfile();
		Thread.sleep(2000);
		Sk.navigateToSkills();
	}

	@Test(priority = 2)
	public void verifyRequiredFields() {
		Sk.requiredFields();
	}

	@Test(priority = 3)
	public void verifyDisabledFields() {
		Sk.disabledFields();
	}

	@Test(priority = 4)
	public void fillSkillDetails() throws InterruptedException {
		Sk.fillTheSkills();
	}
	
	@Test(priority = 5)
	public void verifyEditSkills() throws InterruptedException {
		Sk.editSkills();
	}
}
