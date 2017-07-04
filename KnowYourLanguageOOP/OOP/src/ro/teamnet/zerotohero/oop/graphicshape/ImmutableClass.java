package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class ImmutableClass {

    // fields
    private final int number1;

    // methods
    public void print(){
        System.out.println("Number1 value is " + getNumber1());
    }

    // constructors
    public ImmutableClass(){
        number1 = 5;
    }

    // getters
    private int getNumber1() {
        return number1;
    }
}
