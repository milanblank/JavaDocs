package exercise.exercise0;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(10);
        list.add(6);
        list.add(20);
        list.add(1);

        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)



        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        ListIterator<Integer> it = list.listIterator();
        System.out.print("ListInterator: ");
        while (it.hasNext()){
            int value = it.next();
            System.out.print(value + " ");
        }

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        System.out.println();
        System.out.print("Classic for loop: ");
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        System.out.println();
        System.out.print("Enhanced foreach loop: ");
        for (int value: list
             ) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 ex = new Exercise0();
        ex.iterateThroughList();
    }
}
