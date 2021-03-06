package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindById(){
        Department department = new Department();
        EntityManagerImpl entityManager = new EntityManagerImpl();

        department = entityManager.findById(Department.class, 10L);

        assertEquals( "Administration", department.getDepartmentName());
    }

    @Test
    public void testGetNextIdVal(){
        EntityManagerImpl entityManager = new EntityManagerImpl();

        long nextIdVal = entityManager.getNextIdVal("departments", "department_id");

        assertEquals(270, nextIdVal);
    }


//    @Test
//    public void testInsert(){
//
//        Department department = new Department();
//        EntityManagerImpl entityManager = new EntityManagerImpl();
//
//        long department_id = entityManager.getNextIdVal("departments", "department_id");
//
//        department.setId(department_id);
//        department.setDepartmentName("RR");
//        department.setLocation(1700L);
//
//
//        entityManager.insert(department);
//
//        Department rr = entityManager.findById(department.getClass(), department_id);
//
//        assertEquals("RR", rr.getDepartmentName());
//
//    }

    @Test
    public void testFindAll(){
        EntityManagerImpl entityManager = new EntityManagerImpl();

        List<Department> all = entityManager.findAll(Department.class);
        final ListIterator<Department> departmentListIterator = all.listIterator();
        final Department next = departmentListIterator.next();

        assertEquals( "Administration", next.getDepartmentName());

        final Department next1 = departmentListIterator.next();
        assertEquals( "Marketing", next1.getDepartmentName());
    }

    @Test
    public void testUpdate(){
        EntityManagerImpl entityManager = new EntityManagerImpl();

        Department marketing = entityManager.findById(Department.class, 20L);
        marketing.setDepartmentName("Marketing2");

        entityManager.update(marketing);

        Department marketing2 = entityManager.findById(Department.class, 20L);
        String departmentName = marketing2.getDepartmentName();

        assertEquals("Marketing2", departmentName);

    }

    @Test
    public void testDelete(){
        Department department = new Department();
        EntityManagerImpl entityManager = new EntityManagerImpl();

        department.setId(270L);
        department.setDepartmentName("Payroll");
        department.setLocation(2500L);

        entityManager.delete(department);

        assertNull(entityManager.findById(Department.class, new Long(270)));
    }

    @Test
    public void testFindByParams(){
        Department department = null;
        EntityManagerImpl entityManager = new EntityManagerImpl();

        Map<String, Object> params = new HashMap<>();
        params.put("department_id", 100);
        params.put("location_id", 1700);

        final List<Department> byParams = entityManager.findByParams(Department.class, params);
        ListIterator<Department> it = byParams.listIterator();
        department = it.next();
        String departmentName = department.getDepartmentName();

        assertEquals("Finance", departmentName);

    }
}
