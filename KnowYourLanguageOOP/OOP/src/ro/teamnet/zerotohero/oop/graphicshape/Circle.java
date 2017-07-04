package ro.teamnet.zerotohero.oop.graphicshape;

import static java.lang.Math.PI;
/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class Circle extends Shape {

    // fields
    private int xPos;
    private int yPos;
    private int radius;

    // methods
    public double area(){
        return PI * radius * radius;
    }

    public void fillColour(){
        System.out.println(super.color);
    }

    public void fillColour(int par){
        setColor(par);
        System.out.println("The circle color is now " + super.color);
    }

    public void fillColour(float par){
        setSaturation(par);
        System.out.println("The circle color is now " + super.color);
    }


    // constructors
    public Circle (){
        xPos = 20;
        yPos = 20;
        radius = 10;
    }
    public Circle(int radius){
        this.radius = radius;
    }
    public Circle(int radius, int xPos){
        this.radius = radius;
        this.xPos = xPos;
    }
    public Circle(int radius, int xPos, int yPos){
        this.radius = radius;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
    }

    // getters and setters
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
