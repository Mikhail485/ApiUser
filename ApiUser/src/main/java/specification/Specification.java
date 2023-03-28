package specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {

    public Specification() {
    }

    public static RequestSpecification requestSpec() {
        RequestSpecification requestSpecification = (new RequestSpecBuilder()).setBaseUri("https://petstore.swagger.io/v2/").setContentType("application/json").build();
        return requestSpecification;
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        ResponseSpecification responseSpec = (new ResponseSpecBuilder()).expectStatusCode(statusCode).build();
        return responseSpec;
    }

    public static void installSpec(RequestSpecification requestSpec) {
        RestAssured.requestSpecification = requestSpec;
    }

    public static void installSpec(ResponseSpecification responseSpec) {
        RestAssured.responseSpecification = responseSpec;
    }

    public static void installSpec(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    public static void deleteSpec() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }
}
