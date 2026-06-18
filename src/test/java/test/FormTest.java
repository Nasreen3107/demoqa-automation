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
                "Nasreen",
                "B",
                "nasreen@test.com",
                "9876543210"
        );

        form.setDOB("10 Jan 2000");
        form.setSubjects("Maths");
        form.selectHobby();

        form.uploadFile("C:\\Users\\2457276\\OneDrive - Cognizant\\Desktop");

        form.setAddress("Chennai");

        form.selectStateCity();

        form.submitForm();

        Assert.assertTrue(form.isFormSubmitted(), "Form not submitted!");
    }
}