import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000);

        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        int[] quickSortArray = Arrays.copyOf(array, array.length);
        int[] mergeSortArray = Arrays.copyOf(array, array.length);

        long startTime, endTime;

        // Bubble Sort
        startTime = System.nanoTime();
        BubbleSort.sort(bubbleSortArray);
        endTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " ns");

        // Quick Sort
        startTime = System.nanoTime();
        QuickSort.sort(quickSortArray, 0, quickSortArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (endTime - startTime) + " ns");

        // Merge Sort
        startTime = System.nanoTime();
        MergeSort.sort(mergeSortArray, 0, mergeSortArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Merge Sort Time: " + (endTime - startTime) + " ns");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }
}
