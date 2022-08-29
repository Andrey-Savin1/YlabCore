package main.java.Task1;

public class Task1 {

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int avg = 0;
        int count = 0;

        int[][] array = new int[6][6];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 1010 - 44);
            }
        }

        for (int[] ints : array) {
            for (int j = 0; j < array.length; j++) {

                if (ints[j] < min) {
                    min = ints[j];
                } else if (ints[j] > max) {
                    max = ints[j];
                }
                count++;

                sum += ints[j];

                avg = sum / count;
            }
        }
        System.out.println("Минимальное значение: " + min + "\n"+ "Максимальное значение: " + max + "\n" + "Среднее значение: " + avg);
    }
}

