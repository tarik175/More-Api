package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get11 extends GoRestBaseUrl {

    @Test
    public void get01(){
        spec.pathParam("first","users");

        //2.step Set the expected data
        //3.Step: Send the Request and Get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4.Step: Do Assertions
        //1.Way: By using body()
        response.then().assertThat().statusCode(200).
                body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data.id", hasSize(20),
                        "data.status", hasItem("active"),
                        "data.name",hasItems("Indra Ganaka","Charvi Bhattathiri","Ekaling Butt"));
        //I will compare the number of female and male users in 2 ways
        //1. I will get all genders then I will count the females then I will calculate males then I will check which one is more
        JsonPath json=response.jsonPath();
        List<String> genders=json.getList("data.gender");
        System.out.println(genders);
        int numOfFemales=0;
        for (String w:genders){
            if (w.equals("female")){
                numOfFemales++;
            }
        }
        System.out.println(numOfFemales);

        //2)I will get all females by using Groovy, I will get all males by using Groovy then compare them
        List<String> femaleList=json.getList("data.findAll{it.gender='female'}.gender");
        List<String> maleList=json.getList("data.findAll{it.gender='female'}.gender");
        System.out.println(femaleList);






    }
}
