package com.tests.api;

import com.steps.api.BoardApiSteps;
import com.steps.api.CardApiSteps;
import com.steps.api.ListApiSteps;
import junit.framework.TestCase;
import net.bytebuddy.utility.RandomString;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;

public class BaseApiTest extends TestCase {
    @Steps
    protected BoardApiSteps boardApiSteps;
    @Steps
    protected CardApiSteps cardApiSteps;
    @Steps
    protected ListApiSteps listApiSteps;

    protected String boardName = RandomString.make(10);

    @Before
    public void setup(){
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "8080");
        System.setProperty("env", "test-env");

        boardApiSteps.createBoard(boardName);
    }
}
