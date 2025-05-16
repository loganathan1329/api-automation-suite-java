package apis;

import config.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookstoreApi {
    private RequestSpecification request;

    public BookstoreApi() {
        request = RestAssured.given()
                .baseUri(Endpoints.BASE_URL)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public Response getAllBooks() {
        return request.get(Endpoints.BOOKS);
    }

    public Response getBookById(int id) {
        return request.pathParam("id", id).get(Endpoints.BOOK_BY_ID);
    }

    public Response createBook(String bookJson) {
        return request.body(bookJson).post(Endpoints.BOOKS);
    }

    public Response updateBook(int id, String bookJson) {
        return request.pathParam("id", id).body(bookJson).put(Endpoints.BOOK_BY_ID);
    }

    public Response deleteBook(int id) {
        return request.pathParam("id", id).delete(Endpoints.BOOK_BY_ID);
    }
}
