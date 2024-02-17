package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();
    ArrayList<String> typePool = new ArrayList<>();

    public void addDish(String dishType, String dishName) {
        if (dishType.isEmpty() || dishName.isEmpty()) {
            return;
        }

        if (dishesByType.containsKey(dishType)) {
            ArrayList<String> dishes = dishesByType.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByType.put(dishType, dishes);
        }
    }

    public boolean checkType(String type) {
        return false;
    }

    public void addToTypePool(String type) {

    }

    public ArrayList<ArrayList<String>> generateDinners(int numberOfCombos) {
        return new ArrayList<>();
    }

    public void printDishesByType() {
        for (String dishType : dishesByType.keySet()) {
            System.out.println(dishType + ":");
            for (String dishName : dishesByType.get(dishType)) {
                System.out.println(dishName);
            }
        }
    }
}
