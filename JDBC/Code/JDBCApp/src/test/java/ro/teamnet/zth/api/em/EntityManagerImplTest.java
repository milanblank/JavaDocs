package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.List;
import java.util.ListIterator;

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
}
