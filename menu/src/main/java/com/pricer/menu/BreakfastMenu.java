package com.pricer.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class that represents breakfast menu. A breakfast menu consists of a list of food.
 */
public class BreakfastMenu {

    private List<Food> food = new ArrayList<Food>();

    /**
     * @return a copy of food list.
     */
    public List<Food> getFood() {
        List<Food> foodCopy = new ArrayList<Food>();
        for (Food f : food) {
            foodCopy.add(f);
        }
        return foodCopy;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    /**
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        String str = "Food:\n";
        for (Food f : food) {
            str += f.toString();
        }
        return str;
    }

    /**
     * Sorts the food list according to the order specified by the comparator
     * @param dirx Direction of sorting, either ascending or descending.
     */
    public void sort(String dirx) {

        if (dirx.equals("asc")) {
            Collections.sort(food, Food.Comparators.NAME);
        } else if (dirx.equals("desc")) {
            Collections.sort(food, Collections.reverseOrder(Food.Comparators.NAME));
        }

    }
}
