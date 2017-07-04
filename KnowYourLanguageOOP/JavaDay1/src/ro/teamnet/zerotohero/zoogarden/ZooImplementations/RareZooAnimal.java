package ro.teamnet.zerotohero.zoogarden.ZooImplementations;

import ro.teamnet.zerotohero.zoogarden.ZooExceptions.AnimalEatingManException;
import ro.teamnet.zerotohero.zoogarden.ZooInterfaces.ZooEmployee;

/**
 * Created by Milan.Stojiljkovic on 7/4/2017.
 */
public class RareZooAnimal extends Animal {


    // fields
    private String name;
    private String countryOfOrigineName;


    // constructors
    public RareZooAnimal() {
    }

    public RareZooAnimal(String name) {
        this.name = name;
    }

    public RareZooAnimal(String name, String countryOfOrigineName) {
        this(name);
        this.countryOfOrigineName = countryOfOrigineName;
    }


    // methods
    @Override
    protected void eat(Object obj) throws AnimalEatingManException {
        if(obj instanceof ZooEmployee)
            throw new AnimalEatingManException();
        System.out.println("RareZooAnimal is eating!");
    }

    @Override
    protected void play() {
        super.sleep();
        System.out.println("RareZooAnimal plays");
    }

    @Override
    protected void takeBath() {
        System.out.println("RareZooAnimal taking the bath");
    }


    // getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigineName() {
        return countryOfOrigineName;
    }

    public void setCountryOfOrigineName(String countryOfOrigineName) {
        this.countryOfOrigineName = countryOfOrigineName;
    }
}
