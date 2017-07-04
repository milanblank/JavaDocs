package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class Shape extends AbstractShape{

    // fields
    protected int color;
    protected float saturation;


    // methods
    public double area(){
        return 0;
    }


    // constructors
    public Shape(){}

    public Shape(int color){
        this.color = color;
    }

    public Shape(float saturation){
        this.saturation = saturation;
    }

    // getters and setters
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSaturation() {
        return saturation;
    }

    public void setSaturation(float saturation) {
        this.saturation = saturation;
    }




}
