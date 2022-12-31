package post_requests;

import base_urls.AgroMonitoringBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.AgroMonitoringApiTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class Post03 extends AgroMonitoringBaseUrl {






    @Test
    public void post01(){
        spec.pathParams("first","agro","second",1.0,"third","polygons").
                queryParams("appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0","duğlicated",true);


        AgroMonitoringApiTestData requestBody= new AgroMonitoringApiTestData();
        Map<String, Object> requestBodyMap=requestBody.requestBody();

        Response response=given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().post("/{first}/{second}/{third}");
        response.prettyPrint();

    }


}
