package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;



public class Get13 extends GoRestBaseUrl {





    @Test
    public void get01Pojo(){
        spec.pathParams("first","users","second",12);

        GoRestDataPojo goRestDataPojo=new GoRestDataPojo(13,"Sanya Pandey","sanya_pandey@collier.io","female","inactive");

        GoRestResponseBodyPojo goRestResponseBodyPojo=new GoRestResponseBodyPojo(null,goRestDataPojo);

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        GoRestResponseBodyPojo actualPojo=response.as(GoRestResponseBodyPojo.class);

        assertEquals(goRestResponseBodyPojo.getMeta(),actualPojo.getMeta());



    }








}
