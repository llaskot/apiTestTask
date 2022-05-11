package reqresTests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static reqresTests.Constants.Urls.*;

public class Tests extends Base{

    @Test()
    public void createUser (){
        Constants.Requests request = new Constants.Requests();
        given()
                .spec(requestPost(request.toString()))
        .when()
                .log().all()
                .post(ADD_USER_ENDPOINT)
        .then()
                .spec(responseEvents(201))
                .log().all()
                .body("name", equalTo(request.name))
                .body("job", equalTo(request.job))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }


    @Test()
    public void getUserById (){
        Constants.Requests request = new Constants.Requests();
        String body =
        given()
                .spec(getRequest())
        .when()
                .log().all()
                .get(GET_USER_BY_ID+USER_ID)
        .then()
                .spec(responseEvents(200))
                .log().all()
                .extract().body().asString();
        Gson gson= new Gson();
        JsonObject bodyJs = gson.fromJson(body, JsonObject.class);
        Set<String> keys = bodyJs.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            Assert.assertEquals(bodyJs.get(iter.next()).getClass().toString(), "class com.google.gson.JsonObject");
        }
            System.out.println(bodyJs.getAsJsonObject("data").get("avatar").toString());
        Assert.assertTrue(bodyJs.getAsJsonObject("data").get("avatar").toString().contains(bodyJs.getAsJsonObject("data").get("id").toString()));
    }

    @Test()
    public void deleteUser () {
        Constants.Requests request = new Constants.Requests();
        given()
                .spec(deleteRequest())
                .when()
                .log().all()
                .delete(DELETE_USER + USER_ID)
                .then()
                .spec(responseEvents(204))
                .log().all();
    }
}
