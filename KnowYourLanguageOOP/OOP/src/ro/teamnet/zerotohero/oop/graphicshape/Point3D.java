package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class Point3D extends Point {

    // fields
    private int zPos;

    // methods

    //constructors
    public Point3D(int xPos, int yPos, int zPos){
        super(xPos, yPos);
        this.zPos = zPos;
    }
}
