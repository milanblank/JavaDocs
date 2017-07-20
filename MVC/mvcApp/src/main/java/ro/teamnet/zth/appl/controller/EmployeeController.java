package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.web.RequestTypeEnum;

import java.util.List;

/**
 * Created by Milan.Stojiljkovic on 7/20/2017.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {
    EmployeeDao employeeDao = new EmployeeDao();

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllEmployees(){
//        List<Employee> allEmployeesList = employeeDao.getAllEmployees();
//        StringBuilder sb = new StringBuilder();
//        for (Employee employee: allEmployeesList) {
//            employee.g
//        }
        return "allEmployees";
//        return null;
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneEmployee(){
        return "oneRandomEmployee";
    }


}
