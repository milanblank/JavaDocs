package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class Square extends Shape {

    // fields
    private int side;

    // methods
    public double area(){
        return side * side;
    }

    // constructors
    public Square(int side){
        this.side = side;
    }
}
