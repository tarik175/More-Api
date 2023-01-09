package post_requests;

import base_urls.BaseUrlHerokuapp1;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends BaseUrlHerokuapp1 {


    @Test
    public void post01(){
        spec.pathParam("first","booking");
        HerokuAppTestData herokuApp=new HerokuAppTestData();
        Map<String,String> bookingDatesMap=herokuApp.bookingDateSetup("2020-09-09","2020-09-21");
        Map<String, Object> expectedDataMap=herokuApp.expectedDataSetUp("Selim","Ak",11111,true,bookingDatesMap);


        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
        response.prettyPrint();

        Map<String, Object> actualDataMap=response.as(HashMap.class);

        assertEquals(expectedDataMap.get("firstname"),((Map)actualDataMap.get("booking")).get("firstname"));





    }
}
