package post_requests;

import base_urls.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post04Pojo extends BaseUrlJsonPlaceHolder {







    @Test
    public void postPojo01(){

        spec.pathParam("first","todos");

        JsonPlaceHolderPojo requestBody=new JsonPlaceHolderPojo(55,"Tidy your room",false);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(requestBody).when().post("/{first}");

        JsonPlaceHolderPojo actualBody=response.as(JsonPlaceHolderPojo.class);

        assertEquals(requestBody.getUserId(), actualBody.getUserId());
        assertEquals(requestBody.getTitle(), actualBody.getTitle());
        assertEquals(requestBody.getCompleted(), actualBody.getCompleted());
















    }














}
