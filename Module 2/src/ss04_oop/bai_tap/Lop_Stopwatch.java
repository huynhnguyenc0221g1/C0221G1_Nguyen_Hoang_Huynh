package ss04_oop.bai_tap;

import java.lang.*;
import java.util.Random;

class Stopwatch {
    private long startTime;
    private long endTime;

    private long getStartTime() {
        return this.startTime;
    }

    private long getEndTime() {
        return this.endTime;
    }

    Stopwatch() {
        this.startTime = System.currentTimeMillis();
    }

    long start() {
        return this.startTime = System.currentTimeMillis();
    }

    long end() {
        return this.endTime = System.currentTimeMillis();
    }

    long getElapsedTime() {
        return this.endTime - this.startTime;
    }

}

public class Lop_Stopwatch {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        Random random = new Random();
        int int_random = random.nextInt(Integer.MAX_VALUE);
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = int_random;
            int_random = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println();
        System.out.println("Start sorting time:" + stopwatch.start());
        sortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("End sorting time:" + stopwatch.end());
        System.out.println("Elapsed time:" + stopwatch.getElapsedTime());
    }

    private static void sortArray(int[] array) {
        boolean swapped = true;
        int j = 0;
        int temp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}

