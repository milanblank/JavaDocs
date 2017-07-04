package ro.teamnet.zerotohero.zoogarden.ZooImplementations;

import ro.teamnet.zerotohero.zoogarden.ZooExceptions.AnimalExctinctException;
import ro.teamnet.zerotohero.zoogarden.ZooInterfaces.ZooEmployee;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class ZooKeeper implements ZooEmployee {

    // fields

    // constructors

    // methods
    @Override
    public void work(Animal animal) {
        System.out.println("The keeper enters the animal cage");
    }

    public void work(Animal animal, Object food) throws AnimalExctinctException {
        if (animal == null) {
            throw new AnimalExctinctException();
        }
        this.work(animal);
        animal.eat(food);
        animal.play();
        animal.sleep();
        animal.takeBath();
    }
}
