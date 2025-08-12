package TestDataBuild;

public enum getAPIPath {

   
    AddPlaceAPI("maps/api/place/add/json"),
    getPlaceAPI("maps/api/place/get/json"),
    deletePlaceAPI("maps/api/place/delete/json");
    private String path;

    
     getAPIPath(String path) {
        this.path=path;
    }

    public String  getResourse(){
        return path;

    }

}
