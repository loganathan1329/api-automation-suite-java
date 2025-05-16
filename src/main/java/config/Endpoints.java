package config;

public class Endpoints {
    public static final String BASE_URL = PropertyLoader.getProperty("base.url");
    public static final String BOOKS = "/books";
    public static final String BOOK_BY_ID = "/books/{id}";
    public static final String CUSTOMERS = "/customers";
    public static final String CUSTOMER_BY_ID = "/customers/{id}";
    public static final String ORDERS = "/orders";
    public static final String ORDER_BY_ID = "/orders/{id}";
}
