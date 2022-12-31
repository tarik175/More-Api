package test_data;

import java.util.HashMap;
import java.util.Map;

public class AgroMonitoringApiTestData {

    public float coordinates[][][]= { {
            {-121.1958F,37.6683F},
            {-121.1779F,37.6687F},
            {-121.1773F,37.6792F},
            {-121.1958F,37.6792F},
            {-121.1958F,37.6683F}
                                     } };

    public Map<String, Object> geometrySetUp(){
        Map<String, Object> geometry= new HashMap<>();
        geometry.put("coordinates",coordinates);
        geometry.put("type","polygon");
        return geometry;
    }
    Map<String, Object> properties=new HashMap<>();

    public Map<String, Object> geo_JsonSetUp(){
        Map<String, Object> geo_json= new HashMap<>();
        geo_json.put("geometry",geometrySetUp());
        geo_json.put("type","Feature");
        geo_json.put("properties",properties);
    }

}
