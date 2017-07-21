package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.LocationDao;

/**
 * Created by Milan.Stojiljkovic on 7/20/2017.
 */
@MyController(urlPath = "/locations")
public class LocationController {
    LocationDao locationDao = new LocationDao();

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllLocations(){
        return "allLocations";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneLocation(){
        return "oneRandomLocation";
    }
}
