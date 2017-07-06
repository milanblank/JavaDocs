package com.java_8_training.problems.lambdas;

import com.java_8_training.problems.lambdas.model.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class BehaviourParameterisation {


    //TODO: 1. Implement the method prettyPrintOnlyWeightApple which prints to the console something like 'An apple of 60 grams'
    //TODO: 2. Declare a new method prettyPrintApple which takes different formatters as parameter.
    // The formatter should be an interface that has a method which accepts an apple and returns a string from it.
    // Use the COllections.sort() method as an example


    //TODO: can you refactor prettyPrintOnlyWeightApple to use it?
    //TODO: can you refactor prettyPrintHeavyLightApple to use it?
    //TODO: can you make prettyPrintApple generic (i.e. can work with any type not just Apple)?

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));


        prettyPrintHeavyLightApple(inventory);
        //prettyPrintOnlyWeightApple(inventory);

        System.out.println( "Func int impl");
         prettyPrintApple(inventory, new ApplePrinterColorClass());

        System.out.println(" ANonymus");
         prettyPrintApple(inventory, new ApplePrinter() {
             @Override
             public void print(Apple apple) {
                 System.out.println("My " + apple.getColor() + " apple of " + apple.getWeight() + " grams.");
             }
         });
    }

    public static void prettyPrintHeavyLightApple(List<Apple> inventory) {
        Objects.requireNonNull(inventory, "Inventory must not be null");
        for (Apple apple : inventory) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            String output = "A " + characteristic + " " + apple.getColor() + " apple";
            System.out.println(output);
        }
    }


    public static void prettyPrintApple(List<Apple> inventory, ApplePrinter printer){
        for (Apple apple : inventory) {
            printer.print(apple);
        }
    }
    /**
     * Prints all the weights from the inventory one by one
     *
     * @param inventory
     */
    public static void prettyPrintOnlyWeightApple(List<Apple> inventory) {
        Objects.requireNonNull(inventory, "Inventory must not be null");
        //TODO
        for (Apple apple : inventory)
            System.out.println("An apple of " + apple.getWeight());
    }


}

interface ApplePrinter{
    public void print(Apple apple);
}

class ApplePrinterColorClass implements ApplePrinter {

    @Override
    public void print(Apple apple) {
        System.out.println("A " + apple.getColor() + " apple");
    }
}