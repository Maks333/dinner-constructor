package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType = new HashMap<>();
    Random randomizer = new Random();

    public void addDish(String dishType, String dishName) {
        boolean isDishTypeEmpty = (dishType.isEmpty() || dishType.isBlank());
        boolean isDishNameEmpty = (dishName.isEmpty() || dishName.isBlank());
        if (isDishTypeEmpty || isDishNameEmpty) {
            System.out.println("Имя и тип блюд не должны быть пустыми.");
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
        return dishesByType.containsKey(type);
    }

    public ArrayList<ArrayList<String>> generateDinners(int numberOfCombos, ArrayList<String> typePool) {
        ArrayList<ArrayList<String>> dinnerCombos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String dishType : typePool) {
                ArrayList<String> dishes = dishesByType.get(dishType);
                int dishPosition = randomizer.nextInt(dishes.size());
                String dishToAdd = dishes.get(dishPosition);
                combo.add(dishToAdd);
            }
            dinnerCombos.add(combo);
        }
        return dinnerCombos;
    }

    public void printDinnerCombos(ArrayList<ArrayList<String>> dinnerCombos) {
        for (int i = 0; i < dinnerCombos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(dinnerCombos.get(i));
        }
    }
}
