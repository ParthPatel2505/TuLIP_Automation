package MentorPanelTest;

import MentorPanel.Department_Management;
import base.TestBase;
import utils.Testutils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class Department_ManagementTest extends TestBase {

    Department_Management department;
    public Department_ManagementTest() throws IOException {
        super();
        // TODO Auto-generated constructor stub
    }

    @BeforeClass
    public void setup() throws IOException {
        super.initialization();
        department = new Department_Management();
        Testutils.ValidateUserLogin();
    }

    @Test(priority = 1)
    public void Verify_navigatetodepartment_functionality() throws InterruptedException {
        department.navigate_to_department();
    }

    @Test(priority = 2)
    public void Verify_add_department_functionality() throws Exception
    {
        department.adddepartment();
    }

    @Test(priority = 3)
    public void Verify_edit_department_functionality() throws Exception
    {
        department.edit_department();
    }

    @Test(priority = 4)
    public void Verify_delete_category_functionality() throws Exception
    {
        department.delete_department();
    }
}
