package base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.PropertyLoader;

public class TestHooks {
    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = PropertyLoader.getProperty("base.url");
        RestAssured.filters(new AllureRestAssured());
    }

    @AfterSuite
    public void teardown() {
        // Any cleanup if needed
    }
}
