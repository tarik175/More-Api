package post_requests;

import base_urls.AgroMonitoringBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.AgroMonitoringApiTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Post03 extends AgroMonitoringBaseUrl {






    @Test
    public void post01(){
        spec.pathParams("first","agro","second",1.0,"third","polygons").
                queryParams("appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0","duğlicated",true);


        AgroMonitoringApiTestData requestBody= new AgroMonitoringApiTestData();
        Map<String, Object> requestBodyMap=requestBody.requestBody();

        Response response=given().spec(spec).contentType(ContentType.JSON).body(requestBodyMap).when().post("/{first}/{second}/{third}");
        response.prettyPrint();

        Map<String, Object> actualDataMap=response.as(HashMap.class);

        //Do assertions
        //1.Way:
        assertEquals(requestBodyMap.get("name"), actualDataMap.get("name"));
        assertEquals(requestBodyMap.get("area"), actualDataMap.get("area"));
        assertEquals(String.valueOf(requestBody.coordinates[0][0][0]),((Map)((Map)actualDataMap.get("geo_json")).get("geometry")).get("coordinates").toString().substring(3,12));
        assertEquals(requestBody.geometrySetUp().get("type"),((Map)((Map)actualDataMap.get("geo_json")).get("geometry")).get("type"));

        //2.Way:
        JsonPath json=response.jsonPath();
        assertTrue(json.getFloat("geo_json.geometry.coordinates[0][0][0]")==requestBody.coordinates[0][0][0]);
        assertTrue(json.getString("geo_json.geometry.type").equals(requestBody.geometrySetUp().get("type")));
        assertTrue(json.getString("geo_json.type").equals(requestBody.geo_JsonSetUp().get("type")));
        assertTrue(json.getJsonObject("geo_json.properties").equals(requestBody.geo_JsonSetUp().get("properties")));




    }


}
