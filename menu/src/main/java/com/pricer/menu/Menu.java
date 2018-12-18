package com.pricer.menu;

/**
 * A class that represents menu.
 */
public class Menu {

    private BreakfastMenu breakfast_menu;

    /**
     * @return a copy of breakfast menu.
     */
    public BreakfastMenu getBreakfastMenu() {
        BreakfastMenu breakfastMenuCopy = new BreakfastMenu();
        breakfastMenuCopy.setFood(breakfast_menu.getFood());
        return breakfastMenuCopy;
    }

    public void setBreakfastMenu(BreakfastMenu breakfast_menu) {
        this.breakfast_menu = breakfast_menu;
    }

    /**
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Breakfast Menu:\n" + breakfast_menu.toString();
    }

    /**
     * Sorts the food in the breakfast menu.
     * @param dirx Direction of sorting, either ascending or descending.
     */
    public void sort(String dirx) {
        breakfast_menu.sort(dirx);
    }
}
