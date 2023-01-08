package patch_requests;

import base_urls.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.TestDataJsonPlaceHolder;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Patch01 extends BaseUrlJsonPlaceHolder {


    /*

     */
    @Test
    public void patch01(){
        spec.pathParams("first","todos","second",198);
        TestDataJsonPlaceHolder requestBody=new TestDataJsonPlaceHolder();
        Map<String, Object> requestBodyMap=requestBody.expectedDataWithMissingKeys(null,"Wash the dishes",null);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().patch("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("title", equalTo(requestBodyMap.get("title")));

        Map<String, Object> mapToAssertAllDetails=requestBody.expctedDataOlustur(10,"Wash the dishes",true);

        response.then().assertThat().statusCode(200).body("title", equalTo(mapToAssertAllDetails.get("title")),
                                    "userId", equalTo(mapToAssertAllDetails.get("userId")),
                                    "completed", equalTo(mapToAssertAllDetails.get("completed")));






    }




























}
