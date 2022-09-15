package main.java.Task3;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        if (RAW_DATA == null) {
            System.out.println("Вы передаете null");
        } else {
            System.out.println("Raw data:");
            System.out.println();

            for (Person person : RAW_DATA) {
                System.out.println(person.id + " - " + person.name);
            }

            System.out.println();
            System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
            System.out.println();
            if (RAW_DATA == null) {
                System.out.println("Вы передаете null");
            } else {
                Map<String, Long> accidents = Arrays.stream(RAW_DATA)
                        .distinct()
                        .collect(groupingBy(Person::getName, counting()));
                for (Map.Entry<String, Long> i : accidents.entrySet()) {

                    System.out.println("Key: " + i.getKey());
                    System.out.println("Value: " + i.getValue());

                }
            }
        }
        System.out.println("");
        System.out.println("**************************************************");
        System.out.println("");
        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */

       /*
        Task2  [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
         */

        int[] array = new int[]{3, 4, 2, 7};
        SumOfTwoElementsInArray_v1(array, 7);
        SumOfTwoElementsInArray_v2(array, 7);

        System.out.println("");
        System.out.println("**************************************************");
        System.out.println("");

       /*
        Task3
            Реализовать функцию нечеткого поиска
            */

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false


    }

    public static void SumOfTwoElementsInArray_v1(int[] array, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] printArray = new int[2];

        if (array == null) {
            System.out.println("Вы передаете null");
        } else {
            for (int i = 0; i < array.length; i++) {
                map.put(array[i], i);
                int a = array[i];
                int b = sum - array[i];
                if (map.containsKey(b)) {
                    printArray[0] = a;
                    printArray[1] = b;
                }
            }
            System.out.println(Arrays.toString(printArray));
        }
    }

    public static void SumOfTwoElementsInArray_v2(int[] array, int sum) {
        int[] printArray = new int[2];
        if (array == null) {
            System.out.println("Вы передаете null");
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {

                    if (array[i] + array[j] == sum) {
                        printArray[1] = array[i];
                        printArray[0] = array[j];
                    }
                }
            }
            System.out.println(Arrays.toString(printArray));
        }
    }


    public static boolean fuzzySearch(String line, String search) {

        if (line == null || search == null) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < search.length(); i++) {
            if (line.charAt(index) == search.charAt(i)) {
                index++;
            }
            if (index == line.length()) {
                return true;
            }
        }
        return false;
    }
}
