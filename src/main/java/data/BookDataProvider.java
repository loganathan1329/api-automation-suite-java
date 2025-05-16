package data;

import org.testng.annotations.DataProvider;

public class BookDataProvider {
    @DataProvider(name = "validBooks")
    public static Object[][] validBooks() {
        return new Object[][] {
                {"{\"title\":\"Clean Code\",\"author\":\"Robert Martin\",\"year\":2008,\"price\":35.99}"},
                {"{\"title\":\"Design Patterns\",\"author\":\"Gang of Four\",\"year\":1994,\"price\":45.50}"}
        };
    }

    @DataProvider(name = "invalidBooks")
    public static Object[][] invalidBooks() {
        return new Object[][] {
                {"{\"title\":\"\",\"author\":\"\",\"year\":0,\"price\":0}"}, // Empty values
                {"{\"title\":\"A\",\"author\":\"B\",\"year\":-100,\"price\":-10}"} // Negative values
        };
    }
}
