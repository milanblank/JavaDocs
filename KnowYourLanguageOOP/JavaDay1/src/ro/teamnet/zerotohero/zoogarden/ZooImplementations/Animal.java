package ro.teamnet.zerotohero.zoogarden.ZooImplementations;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public abstract class Animal {

    // fields

    // abstract methods
    protected abstract void eat(Object obj);
    protected abstract void play();
    protected abstract void  takeBath();

    // concrete methods
    public void sleep(){
        System.out.println("Animal sleeps.");
    }

    // constructors

    public Animal() {
        System.out.println("New Animal!");
    }
}
