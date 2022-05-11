package reqresTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static reqresTests.Constants.Urls.DOMAIN_URL;

public class Base {

    static RequestSpecification requestPost(String body) {
        return new RequestSpecBuilder()
                .setBaseUri(DOMAIN_URL)
                .setContentType(ContentType.JSON)
                .setBody(body)
                .build();
    }

    static RequestSpecification getRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(DOMAIN_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

    static RequestSpecification deleteRequest () {
        return new RequestSpecBuilder()
                .setBaseUri(DOMAIN_URL)
                .build();
    }

    static ResponseSpecification responseEvents(int responseCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(responseCode)
                .build();
    }

}
