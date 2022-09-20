package models;

import java.util.ArrayList;

public class Cart {

    ArrayList<Item> items;

    public Cart() {
        this.items = new ArrayList<Item>();
    }

    public Item getItems(int index) {
        return new Item(items.get(index));
    }

    public void setItems(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    /**
     * Name: add
     * 
     * @param item
     * @return boolean
     *
     *         Inside the function:
     *         1. Adds an item to the cart if it wasn't already added.
     */

    public boolean add(Item item) {
        if (items.contains(item)) {
            return false;
        }
        items.add(new Item(item));
        return true;
    }

    /**
     * Name: remove
     * 
     * @param name
     *
     *             Inside the function:
     *             1. Removes the item that matches the name passed in.
     */

    public void remove(Item name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
            }
        }
    }

    /**
     * Name: checkOut
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Calculates the subtotal (price before tax).
     *         2. Calculates the tax (assume tax is 13%).
     *         3. Calculates total: subtotal + tax
     *         4. Returns a String that resembles a receipt. See below.
     */

     public String checkOut(){
        double [] measures = new double[3];
        for (int i = 0; i < items.size(); i++) {
            measures[0] = items.get(i).getPrice();
        }
        measures[1] = measures[0] *0.13;
        measures[2] = measures[0] + measures[1];

        return "\tRECEIPT\n\n" +
        "\tSubtotal: $" + measures[0] + "\n" +
        "\tTax: $" + measures[1] + "\n" +
        "\tTotal: $" + measures[2] + "\n";
     }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }

     

}
