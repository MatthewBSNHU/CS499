import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000);

        int[] bubbleSortArray = Arrays.copyOf(array, array.length);
        int[] quickSortArray = Arrays.copyOf(array, array.length);
        int[] mergeSortArray = Arrays.copyOf(array, array.length);
        int[] radixSortArray = Arrays.copyOf(array, array.length);
        int[] heapSortArray = Arrays.copyOf(array, array.length);

        measureSortTime("Bubble Sort", () -> BubbleSort.sort(bubbleSortArray));
        measureSortTime("Quick Sort", () -> QuickSort.sort(quickSortArray, 0, quickSortArray.length - 1));
        measureSortTime("Merge Sort", () -> MergeSort.sort(mergeSortArray, 0, mergeSortArray.length - 1));
        measureSortTime("Radix Sort", () -> RadixSort.sort(radixSortArray));
        measureSortTime("Heap Sort", () -> HeapSort.sort(heapSortArray));
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }

    private static void measureSortTime(String sortName, Runnable sortFunction) {
        long startTime = System.nanoTime();
        sortFunction.run();
        long endTime = System.nanoTime();
        System.out.println(sortName + " Time: " + (endTime - startTime) + " ns");
    }
}
