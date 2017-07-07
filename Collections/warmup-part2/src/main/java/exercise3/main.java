package exercise3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Milan.Stojiljkovic on 7/7/2017.
 */
public class main {

    public static void main(String... args){
        Map<Student,BigDecimal> master = new HashMap<Student, BigDecimal>();
        Map<Student,BigDecimal> bechelor = new HashMap<Student, BigDecimal>();
        Map<Student,BigDecimal> softEng = new HashMap<Student, BigDecimal>();
        Map<Student,BigDecimal> mba = new HashMap<Student, BigDecimal>();

        master.put(new WrongHashWrongEqStudent("Milan", "Sto"), BigDecimal.valueOf(30));
        master.put(new WrongHashWrongEqStudent("Milan", "Bla"), BigDecimal.valueOf(30));

        bechelor.put(new WrongHashGoodEqStudent("Milan", "Grey"), BigDecimal.valueOf(40));
        bechelor.put(new WrongHashGoodEqStudent("Milan", "Bla"), BigDecimal.valueOf(20));

        softEng.put(new GoodHashWrongEqStudent("Milan", "Milan"), BigDecimal.valueOf(15));
        softEng.put(new GoodHashWrongEqStudent("Milan", "Milan"), BigDecimal.valueOf(20));

        mba.put(new GoodHashGoodEqStudent("Milan", "Sto"), BigDecimal.valueOf(30));
        mba.put(new GoodHashGoodEqStudent("Milan", "Bla"), BigDecimal.valueOf(30));

        Iterator<Map.Entry<Student,BigDecimal>> it = master.entrySet().iterator();
        System.out.println("WrongHashWrongEqStudent: ");
        while (it.hasNext()){
            Map.Entry<Student,BigDecimal> student = it.next();
            System.out.println(student.getKey() +" "+ student.getValue());
        }

        it = bechelor.entrySet().iterator();
        System.out.println("WrongHashGoodEqStudent: ");
        while (it.hasNext()){
            Map.Entry<Student,BigDecimal> student = it.next();
            System.out.println(student.getKey() +" "+ student.getValue());
        }

        it = softEng.entrySet().iterator();
        System.out.println("GoodHashWrongEqStudent: ");
        while (it.hasNext()){
            Map.Entry<Student,BigDecimal> student = it.next();
            System.out.println(student.getKey() +" "+ student.getValue());
        }

        it = mba.entrySet().iterator();
        System.out.println("GoodHashGoodEqStudent: ");
        while (it.hasNext()){
            Map.Entry<Student,BigDecimal> student = it.next();
            System.out.println(student.getKey() +" "+ student.getValue());
        }
    }
}
