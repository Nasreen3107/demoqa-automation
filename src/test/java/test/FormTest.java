package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormPage;

public class FormTest extends BaseTest {

    @Test
    public void testFullForm() {

        System.out.println("TEST RUNNING");

        FormPage form = new FormPage(driver);

        form.openForm();

        form.fillBasicDetails(
                prop.getProperty("firstname"),
                prop.getProperty("lastname"),
                prop.getProperty("email"),
                prop.getProperty("mobile")
        );

        form.setDOB(prop.getProperty("dob"));
        form.setSubjects(prop.getProperty("subject"));
        form.selectHobby(
                prop.getProperty("hobby")
        );
        String filePath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\sample.pdf";

        form.uploadFile(filePath);
        form.setAddress(prop.getProperty("address"));
        form.selectStateCity(
                prop.getProperty("state"),
                prop.getProperty("city")
        );
        form.submitForm();

        Assert.assertTrue(form.isFormSubmitted(), "Form not submitted!");
    }
}