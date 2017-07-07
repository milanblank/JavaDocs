package exercise0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Iterate over the keys of a Map using keySet method (this method returns a Set of all the map keys) and
 *          print all its elements.
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughMap(){

        // Exercise #0 a) Create a Map (HashMap) and add elements to it (using put() method)
        // Exercise #0 a) Hint: Don't forget to specify the types of the key and value when creating the Map
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        // Exercise #0 b) Iterate over the Map using keySet() method and print all its elements
        // Exercise #0 b) The elements could be printed like this: [key1=value1, key2=value2, ...]
        Set<String> keys = map.keySet();

        System.out.print("[");
        for (String key: keys) {
            System.out.print(key + "=" + map.get(key) + ",");
        }
        System.out.println("]");
        
    }

    public static void main(String[] args) {
        Exercise0 exercise0 = new Exercise0();
        exercise0.iterateThroughMap();
    }
}
