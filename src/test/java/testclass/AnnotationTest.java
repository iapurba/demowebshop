package test.java.testclass;

import org.testng.annotations.*;

public class AnnotationTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class running");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method running");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test running");
    }
    @Test
    public void test1() {
        System.out.println("Test1 running");
    }
    @Test
    public void test2() {
        System.out.println("Test2 running");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test running");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method running");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class running");
    }

}
