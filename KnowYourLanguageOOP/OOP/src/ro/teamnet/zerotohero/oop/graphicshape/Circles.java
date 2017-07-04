package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class Circles {

    // fields

    // methods
    public double getAreaPub(int radius) throws MyCustomException{
        Circle circle = new Circle(radius);
        if (circle.getRadius() < 0) {
            throw new MyCustomException("Radius must be positive value");
        } else {
            return circle.area();
        }
    }

    public void getAreaDef(){
        Circle circle = new Circle();
        circle.fillColour();
        circle.fillColour(2);
        circle.fillColour(3.0f);
    }

}
