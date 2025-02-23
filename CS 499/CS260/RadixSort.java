public class RadixSort {
    public static void sort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
}
