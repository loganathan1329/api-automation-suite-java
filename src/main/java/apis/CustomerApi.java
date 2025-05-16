package apis;

import config.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerApi {
    private RequestSpecification request;

    public CustomerApi() {
        request = RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public Response getAllCustomers() {
        return request.get(Endpoints.CUSTOMERS);
    }

    public Response getCustomerById(int id) {
        return request.pathParam("id", id).get(Endpoints.CUSTOMER_BY_ID);
    }

    public Response createCustomer(String customerJson) {
        return request.body(customerJson).post(Endpoints.CUSTOMERS);
    }

    public Response updateCustomer(int id, String customerJson) {
        return request.pathParam("id", id).body(customerJson).put(Endpoints.CUSTOMER_BY_ID);
    }

    public Response deleteCustomer(int id) {
        return request.pathParam("id", id).delete(Endpoints.CUSTOMER_BY_ID);
    }
}
