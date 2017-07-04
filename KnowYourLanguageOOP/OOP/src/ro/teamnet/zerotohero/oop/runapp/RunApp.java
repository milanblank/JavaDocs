package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

import java.util.Scanner;


/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class RunApp {
    public static void main(String... args){
            Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            Circles circles = new Circles();
            System.out.println("Enter radius value: ");
            int radius = sc.nextInt();
            System.out.println("The default circle area is "+circles.getAreaPub(radius));
            circles.getAreaDef();
        } catch (MyCustomException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

        Canvas canvas = new Canvas();
        //canvas.paint();

        Shape shape = new Circle(10);
        System.out.println("Shape reference - Circle object area is " + shape.area());


        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        ImmutableClass ic = new ImmutableClass();
        ic.print();
        //ic.number1;

    }
}
