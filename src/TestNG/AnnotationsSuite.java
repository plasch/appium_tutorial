package TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsSuite {

    @BeforeSuite
    public void InstallSoftware()
    {
        System.out.println("I'm the First");
    }

    @Test
    public void Software()
    {
        System.out.println("I'm the Test");
    }

    @AfterSuite
    public void UninstallSoftware()
    {
        System.out.println("I'm the Last");
    }
}
