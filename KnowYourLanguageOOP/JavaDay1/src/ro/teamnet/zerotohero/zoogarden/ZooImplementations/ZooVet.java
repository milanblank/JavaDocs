package ro.teamnet.zerotohero.zoogarden.ZooImplementations;

import ro.teamnet.zerotohero.zoogarden.ZooInterfaces.ZooEmployee;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class ZooVet implements ZooEmployee {

    // fields

    // constructors

    // methods

    @Override
    public void work(Animal animal) {
        System.out.println("The vet takes care of the animal");
                if(animal instanceof FerociousZooAnimal)
                animal.takeBath();
                }
                }
