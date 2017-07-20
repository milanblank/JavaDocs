package ro.teamnet.zth.web;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Milan.Stojiljkovic on 7/20/2017.
 */
public class MyDispatcherServlet extends HttpServlet {

    //key = /departments/all_GET
    // value = MethodAttributes   DepartmentController.getAllDepartments

    //key = /departments/one_GET
    // value = MethodAttributes   DepartmentController.getOneDepartment
    Map<String, MethodAttributes> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        String packagePath = "ro.teamnet.zth.appl.controller";
        Iterable<Class> classes = null;
        try {
            classes = AnnotationScanUtils.getClasses(packagePath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Class> it = classes.iterator();

        MethodAttributes methodAttributes = new MethodAttributes();

        while (it.hasNext()){
            StringBuilder key;

            Class next = it.next();

            methodAttributes.setControllerClass(next.getSimpleName());

            MyController myController = (MyController) next.getAnnotation(MyController.class);
            String classPath = myController.urlPath();
            Method[] declaredMethods = next.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                key = new StringBuilder();
                key.append("/app/mvc");
                key.append(classPath);
                methodAttributes.setMethodName(declaredMethod.getName());
                MyRequestMethod myRequestMethod = declaredMethod.getAnnotation(MyRequestMethod.class);
                key.append(myRequestMethod.urlPath())
                        .append("_")
                        .append(myRequestMethod.methodType());
                methodAttributes.setMethodType(myRequestMethod.methodType());
                map.put(key.toString(), methodAttributes);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, RequestTypeEnum.GET.getValue());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, RequestTypeEnum.POST.getValue());
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, String methodType){
        MethodAttributes dispatch = dispatch(req, methodType);
        reply(resp, dispatch);
    }

    private MethodAttributes dispatch(HttpServletRequest req, String methodType){
//        req.getRequestURI() + "_" met
        String requestURI = req.getRequestURI();  //app/mvc/employees/all
        MethodAttributes value = map.get(requestURI + "_" +methodType);
        return value;
    }

    private void reply(HttpServletResponse resp, MethodAttributes methodAttributes){

//        resp.set
        try {
            resp.setContentType("text/html");

            //resp.getWriter().write(methodAttributes != null ? "not null" : "null");
            resp.getWriter().write(methodAttributes.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
