package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceHolder {

    public int basariliStatusCode=200;
    public String contentType="application/json; charset=utf-8";
    public String connectionHeaderDegeri="keep-alive";

    public Map<String, Object> expctedDataOlustur(Integer userid, String title, Boolean completed){

        Map<String, Object> expectedDataJson=new HashMap<>();

        expectedDataJson.put("userId",userid);
        expectedDataJson.put("title",title);
        expectedDataJson.put("completed",completed);


        return expectedDataJson;
    }

    public Map<String, Object> expectedDataWithMissingKeys(Integer userid, String title, Boolean completed){

        Map<String, Object> expectedData=new HashMap<>();
        if (userid!=null){
            expectedData.put("userId",userid);
        }
        if (title!=null){
            expectedData.put("title",title);
        }
        if (completed!=null){
            expectedData.put("completed",completed);
        }
        return expectedData;

    }

    public JSONObject putRequestBodyOlustur() {
        JSONObject requestBody=new JSONObject();
        requestBody.put("userId",10);
        requestBody.put("id",70);
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");

        return requestBody;
    }

    public JSONObject putRequestExpectedBodyOlustur() {
        JSONObject putRequestExpectedBodyJson=new JSONObject();
        putRequestExpectedBodyJson.put("userId",10);
        putRequestExpectedBodyJson.put("id",70);
        putRequestExpectedBodyJson.put("title","Ahmet");
        putRequestExpectedBodyJson.put("body","Merhaba");

        return putRequestExpectedBodyJson;
    }

    public HashMap requestBodyMapOlustur(){

        /*
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
         */

        HashMap<String,Object> requestBodyMap= new HashMap<>();
        requestBodyMap.put("title","Ahmet");
        requestBodyMap.put("body","Merhaba");
        requestBodyMap.put("userId",10.0);
        requestBodyMap.put("id",70.0);

        return requestBodyMap;
    }

    public HashMap requestBodyMapOlustur(String title,String body,double userId,double id){
        HashMap<String,Object> requestBodyMap= new HashMap<>();
        requestBodyMap.put("title",title);
        requestBodyMap.put("body",body);
        requestBodyMap.put("userId",userId);
        requestBodyMap.put("id",id);

        return requestBodyMap;
    }



}

