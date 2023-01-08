package delete_requests;

import base_urls.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Delete01 extends BaseUrlJsonPlaceHolder {





    @Test
    public void delete01(){

        spec.pathParams("first","todos","second",198);

        Map<String , Object> expectedMap=new HashMap<>();


        Response response=given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        Map<String , Object> actualMap=response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expectedMap,actualMap);

        response.then().assertThat().statusCode(200);
        assertTrue(actualMap.size()==0);//OR
        assertTrue(actualMap.isEmpty());



        /*
        How to automate "Delete Request" in API testing?
        1) Create new data by using "Post Request"
        2) Use "Delete Request" to delete newly created data.
        Note:Do no use "Delete Request" for the existing data, create your own data then delete it.
         */





    }












}
