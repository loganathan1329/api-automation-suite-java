package steps;

import apis.CustomerApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class CustomerSteps {
    private CustomerApi customerApi;
    private Response response;
    private int customerId;

    @Given("the customer API is available")
    public void theCustomerAPIIsAvailable() {
        customerApi = new CustomerApi();
    }

    @When("I create a new customer with name {string}, email {string}, and address {string}")
    public void iCreateANewCustomer(String name, String email, String address) {
        String customerJson = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"address\":\"%s\"}", 
                name, email, address);
        response = customerApi.createCustomer(customerJson);
        if (response.getStatusCode() == 201) {
            customerId = response.jsonPath().getInt("id");
        }
    }

    @Then("the customer should be created successfully")
    public void theCustomerShouldBeCreatedSuccessfully() {
        Assert.assertEquals(response.getStatusCode(), 201, "Customer creation failed");
        Assert.assertTrue(customerId > 0, "Customer ID should be positive");
    }

    @Then("I should be able to retrieve the customer details")
    public void iShouldBeAbleToRetrieveTheCustomerDetails() {
        Response getResponse = customerApi.getCustomerById(customerId);
        Assert.assertEquals(getResponse.getStatusCode(), 200, "Customer retrieval failed");
        Assert.assertEquals(getResponse.jsonPath().getString("name"), 
                response.jsonPath().getString("name"), "Name mismatch");
    }
}
