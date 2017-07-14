package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindById(){
        Department department = new Department();
        EntityManagerImpl entityManager = new EntityManagerImpl();

        department = entityManager.findById(Department.class, new Long(10));

        assertEquals( "Administration", department.getDepartmentName());
    }

//    @Test
//    public void testGetNextIdVal(){
//        Department department = new Department();
//        EntityManagerImpl entityManager = new EntityManagerImpl();
//    }


    @Test
    public void testFindAll(){
        Department department = new Department();
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

        Department byId = entityManager.findById(Department.class, new Long(25));
        byId.setDepartmentName("Marketing2");
        entityManager.update(byId);

        Department byId2 = entityManager.findById(Department.class, new Long(25));
        String departmentName = byId2.getDepartmentName();

        assertEquals("Marketing2", departmentName);

    }

//    @Test
//    public void testDelete(){
//        Department department = new Department();
//        EntityManagerImpl entityManager = new EntityManagerImpl();
//    }

    @Test
    public void testFindByParams(){
        Department department = new Department();
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
