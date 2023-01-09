package post_requests;

import base_urls.BaseUrlHerokuapp1;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Post05Pojo extends BaseUrlHerokuapp1 {

    @Test
    public void PostPojo01(){


        spec.pathParam("first","booking");

        BookingDatesPojo bookingDates=new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo bookingPojo=new BookingPojo("Ali","Can",999,true,bookingDates,"Breakfast with white tea, Dragon Juice");

        Response response=given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).when().post("/{first}");




        BookingResponseBodyPojo actualPojo=response.as(BookingResponseBodyPojo.class);


        assertEquals(200,response.getStatusCode());

        assertEquals(bookingPojo.getFirstname(),actualPojo.getBooking().getFirstname());

        assertEquals(bookingPojo.getLastname(),actualPojo.getBooking().getLastname());

        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());


        assertEquals(bookingDates.getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());









    }







}
