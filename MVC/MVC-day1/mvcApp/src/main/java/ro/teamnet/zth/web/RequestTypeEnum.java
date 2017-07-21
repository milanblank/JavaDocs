package ro.teamnet.zth.web;

/**
 * Created by Milan.Stojiljkovic on 7/20/2017.
 */
public enum RequestTypeEnum {

    GET("GET"), POST("GET");

    private String value;

    RequestTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
