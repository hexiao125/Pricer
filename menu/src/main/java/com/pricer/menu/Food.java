package com.pricer.menu;

import java.util.Comparator;

/**
 * A class that represents food. Food can be included in breakfast menus.
 */
public class Food {

    private String name;
    private String price;
    private String description;
    private short calories;

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getCalories() {
        return calories;
    }

    public void setCalories(short calories) {
        this.calories = calories;
    }

    /**
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return " Name: " + name + "\n Price: " + price
                + "\n Description: " + description + "\n Calories: " + calories
                + "\n\n";
    }

    /**
     * This class consists of different food comparators.
     */
    public static class Comparators {
        /**
         * A comparator that compares food according to name.
         */
        public static Comparator NAME = new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                return f1.name.compareTo(f2.name);
            }
        };
    }

}


