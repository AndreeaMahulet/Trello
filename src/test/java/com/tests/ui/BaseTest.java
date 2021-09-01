package com.tests.ui;

import com.steps.api.BoardApiSteps;
import com.steps.api.ListApiSteps;
import com.steps.ui.BoardSteps;
import com.steps.ui.BoardsSteps;
import com.steps.ui.LoginSteps;
import junit.framework.TestCase;
import net.bytebuddy.utility.RandomString;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest extends TestCase {
    @Managed(uniqueSession = true)
    protected WebDriver webdriver;
    @Steps
    protected BoardsSteps boardsSteps;
    @Steps
    protected BoardApiSteps boardApiSteps;
    @Steps
    protected ListApiSteps listApiSteps;
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected BoardSteps boardSteps;
    protected String boardName = RandomString.make(10);
    @Before
    public void setup() {
        System.setProperty("env", "test-env");
    }

}
