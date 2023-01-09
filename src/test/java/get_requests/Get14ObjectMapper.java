package get_requests;

import base_urls.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper extends BaseUrlJsonPlaceHolder {




    @Test
    public void get14ObjectMapper(){

        spec.pathParams("first","todos","second",198);

        String expectedData = "{\n" +
                                "\"userId\": 10,\n" +
                                "\"id\": 198,\n" +
                                "\"title\": \"quis eius est sint explicabo\",\n" +
                                "\"completed\": true\n" +
                                "}";
        HashMap<String, Object> expectedDataMap=JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);


        Response response=given().spec(spec).when().get("/{first}/{second}");

        HashMap<String, Object> actualDataMap=JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);

        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));



    }






}
