package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {


    public Map<String,String> bookingDateSetup(String checkin,String checkout){
        Map<String,String> bookingDateMap= new HashMap<>();
        bookingDateMap.put("checkin",checkin);
        bookingDateMap.put("checkout",checkout);
        return bookingDateMap;
    }

    public Map<String,Object> expectedDataSetUp(String firstname,String lastname,int totalprice,boolean depositpaid,Map<String,String> bookingdates){

        Map<String,Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);
        return expectedDataMap;
    }







}
