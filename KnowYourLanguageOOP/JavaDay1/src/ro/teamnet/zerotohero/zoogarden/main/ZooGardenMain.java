package ro.teamnet.zerotohero.zoogarden.main;

import ro.teamnet.zerotohero.zoogarden.ZooImplementations.*;
import ro.teamnet.zerotohero.zoogarden.ZooInterfaces.ZooEmployee;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class ZooGardenMain {

    public static void main(String... args){
        RareZooAnimal animal1 = new RareZooAnimal("Pinguin");
        RareZooAnimal animal2 = new RareZooAnimal("Elefant", "Africa");
        RareZooAnimal animal3 = new RareZooAnimal();

        FerociousZooAnimal ferociousAnimal = new FerociousZooAnimal();

        ZooEmployee employee1 = new ZooKeeper();
        ZooKeeper employee2 = new ZooKeeper();

        ZooEmployee employee3 = new ZooVet();
        ZooVet employee4 = new ZooVet();

        System.out.println(animal1.getName());
        System.out.println(animal1.getCountryOfOrigineName());
        System.out.println(animal2.getName());
        System.out.println(animal2.getCountryOfOrigineName());

        employee3.work(animal1);
        employee3.work(animal2);
        employee3.work(animal3);
        employee4.work(animal1);
        employee4.work(animal2);
        employee4.work(animal3);

        employee1.work(animal1);
        employee1.work(animal2);
        employee1.work(animal3);

        employee2.work(animal1);
        employee2.work(animal2);
        employee2.work(animal3);
    }
}
