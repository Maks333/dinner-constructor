package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершает работу.");
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        dc.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String dishType = scanner.nextLine();

        //реализуйте ввод типов блюд
        ArrayList<String> typePool = new ArrayList<>();
        while (!dishType.isEmpty()) {
            if (dc.checkType(dishType)) {
                typePool.add(dishType);
            } else {
                System.out.println("Данный тип блюда отсутствует в меню. Введите другой тип блюда.");
            }
            dishType = scanner.nextLine();
        }

        if (typePool.isEmpty()) {
            System.out.println("Отсутствуют типы блюд для генерации комбинаций.");
            return;
        }
        // сгенерируйте комбинации блюд и выведите на экран
        ArrayList<ArrayList<String>> combos = dc.generateDinners(numberOfCombos, typePool);
        dc.printDinnerCombos(combos);
    }
}
