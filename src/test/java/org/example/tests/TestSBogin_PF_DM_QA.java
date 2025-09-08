package org.example.tests;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.example.base.CommonToAllTest;
import org.example.page.pageFactory.LoginPage_PF;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.example.driver.DriverManager.driver;

public class TestSBogin_PF_DM_QA extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestSBogin_PF_DM_QA.class);

    @Test(description = "Verify login with invalid credentials")
    @Description("This test verifies that login fails with wrong username/password")
    @Severity(SeverityLevel.NORMAL)
    @Story("Login Feature")
    @Epic("Authentication Module")
    public void testLoginNegativeSB() throws FileNotFoundException {
        logger.info("Starting Test in QA Environment");
        // ✅ Changed from LoginPage_PF → LoginPage_POM
        LoginPage_PF loginPage_PF = new LoginPage_PF(driver);
        logger.info("Opening the URL");
        loginPage_PF.openVWOLoginURL("qa");
        String error_msg = loginPage_PF.loginTOSBInvalidCreds();
        logger.info("Verifying the Result");
        Assert.assertEquals(error_msg, "Invalid Username Or Password.");

        // Assertj
        Assertions.assertThat(error_msg).isNotNull().isNotBlank();


        driver.quit();
    }

}
