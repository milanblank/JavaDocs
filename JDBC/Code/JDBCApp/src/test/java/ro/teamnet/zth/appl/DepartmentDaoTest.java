package ro.teamnet.zth.appl;

import org.junit.Before;
import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Milan on 16-Jul-17.
 */
public class DepartmentDaoTest {

    @Test
    public void testFindById(){
        DepartmentDao dao = new DepartmentDao();
        Department humanResources = dao.findById(40);
        String departmentName = humanResources.getDepartmentName();

        assertEquals("Human Resources", departmentName);
    }

    @Test
    public void testGetNextIdValue(){
        DepartmentDao dao = new DepartmentDao();
        long nextIdValue = dao.getNextIdValue();

        assertEquals(280, nextIdValue);
    }

//    @Test
//    public void testInsert(){
//        DepartmentDao dao = new DepartmentDao();
//
//        Department cleaning = new Department();
//        long nextIdValue = dao.getNextIdValue();
//        cleaning.setId(nextIdValue);
//        cleaning.setDepartmentName("Cleaning");
//        cleaning.setLocation(new Long(1700));
//
//        Department insert = dao.insert(cleaning);
//
//        Department cleaningInserted = dao.findById(nextIdValue);
//        String departmentName = cleaningInserted.getDepartmentName();
//
//        assertEquals("Cleaning", departmentName);
//        //assertEquals(insert,departmentName);
//    }

    @Test
    public void testFindAll(){
        DepartmentDao dao = new DepartmentDao();

        List<Department> all = dao.findAll();

        ListIterator<Department> it = all.listIterator();
        Department administration = it.next();

        assertEquals("Administration", administration.getDepartmentName());

        Department marketing = it.next();

        assertEquals("Marketing", marketing.getDepartmentName());
    }

    @Test
    public void testUpdate(){
        DepartmentDao dao = new DepartmentDao();

        Department itDevelopers = new Department();
        itDevelopers.setId(60L);

        itDevelopers.setDepartmentName("IT");
        itDevelopers.setLocation(new Long(1700));

        Department update = dao.update(itDevelopers);

        Department IT = dao.findById(60);

        assertEquals("IT", IT.getDepartmentName());
        assertEquals("IT", update.getDepartmentName());
    }
//
//    @Test
//    public void testDelete(){
//        DepartmentDao dao = new DepartmentDao();
//
//        Department sales = new Department();
//        sales.setId(80L);
//        sales.setDepartmentName("Sales");
//        sales.setLocation(2500L);
//
//        dao.delete(sales);
//
//        Department department = dao.findById(80);
//
//        assertNull(department);
//        // java.sql.SQLIntegrityConstraintViolationException:
//        // ORA-02292: integrity constraint (SYS.SYS_C007018) violated - child record found
//    }

    @Test
    public void testFindByParams(){
        DepartmentDao dao = new DepartmentDao();

        Map<String, Object> params = new HashMap<>();
        params.put("department_id", 100);
        params.put("location_id", 1700);

        List<Department> list = dao.findByParams(params);

        ListIterator<Department> it = list.listIterator();
        Department finance = it.next();


        assertEquals("Finance", finance.getDepartmentName());

    }

}
