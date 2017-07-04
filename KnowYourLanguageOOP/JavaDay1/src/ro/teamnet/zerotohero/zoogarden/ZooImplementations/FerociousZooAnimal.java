package ro.teamnet.zerotohero.zoogarden.ZooImplementations;

import ro.teamnet.zerotohero.zoogarden.ZooExceptions.AnimalEatingManException;
import ro.teamnet.zerotohero.zoogarden.ZooInterfaces.ZooEmployee;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class FerociousZooAnimal extends Animal {
    // fields

    // constructors

    // methods

    @Override
    protected void eat(Object obj) throws AnimalEatingManException {
        if(obj instanceof ZooEmployee)
            throw new AnimalEatingManException();
        System.out.println("FerociousZooAnimal is eating!");
    }

    @Override
    protected void play() {
        System.out.println("FerociousZooAnimal plays");
    }

    @Override
    protected void takeBath() {
        System.out.println("FerociousZooAnimal is taking the bath.");
    }

    @Override
    public void sleep() {
        super.sleep();
        System.out.println("The ferocious animal hunts.");
    }
}
