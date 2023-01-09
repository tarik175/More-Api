package get_requests;

import base_urls.BaseUrlHerokuapp1;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import test_data.HerokuAppTestData;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get12 extends BaseUrlHerokuapp1 {







    @Test
    public void get01Pojo(){

        spec.pathParams("first","booking","second",2);

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2020-05-02","2021-04-03");

        BookingPojo bookingPojo=new BookingPojo("Mary","Brown",810,true,bookingDatesPojo,"Breakfast");


        Response response =given().spec(spec).when().get("/{first}/{second}");

        BookingPojo actualPojo=response.as(BookingPojo.class);

        assertEquals(bookingPojo.getFirstname(),actualPojo.getFirstname());
        assertEquals(bookingPojo.getLastname(),actualPojo.getLastname());




    }










}
