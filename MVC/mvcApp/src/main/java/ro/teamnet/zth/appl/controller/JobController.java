package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.JobDao;

/**
 * Created by Milan.Stojiljkovic on 7/20/2017.
 */
@MyController(urlPath = "/jobs")
public class JobController {
    JobDao jobDao = new JobDao();

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllJobs(){
        return "allJobs";
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneJob(){
        return "oneRandomJob";
    }
}
