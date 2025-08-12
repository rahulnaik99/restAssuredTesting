package TestDataBuild;


import java.util.ArrayList;
import java.util.List;

import POJO.mapPOJO.locations;
import POJO.mapPOJO.placePOJO;

public class TestDataBuild 
{
    public placePOJO add_place_payload(String name, String language, String address) {
        placePOJO map = new placePOJO();
        map.setAccuracy(50);
        map.setAddress(address);
        map.setLanguage(language+" -IN");
        map.setWebsite("http://google.com");
        List<String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        map.setTypes(list);
        locations loc = new locations();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        map.setLocation(loc);
        map.setPhone_number("(+91) 983 893 3937");
        map.setName(name);
        return map;
    }

}
