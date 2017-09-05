/**
 * Laboratory #2 of Data Structures and Algorithms 1
 * 
 * @author Mauricio Toro, Agustin Nieto
 * @version 2
 */
public class Laboratory2 {
    
    private Laboratory2(){};

    private static int[] makeRandomArray(int n, int max) {
        int arr[] = new int[n];
        max++;
        java.util.Random a = new java.util.Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = a.nextInt(max);
        }

        return arr;
    }

    /**
     * Computes the sum of an array.
     * Complexity: time O(n), memory O(1)
     *
     * @param A Any array of ints.
     * @return The sum of the elements inside the array.
     */
    public static int ArraySum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        return sum;
    }

    /**
     * Computes the nanoseconds it took to get the sum of the elements in an
     * array with length <code>n</code> and a with a maximum possible value of
     * <code>max</code>.
     *
     * @param n The length of any array. It's the n in the BigO: "O(n)"
     * @param max The maximum value this array can contain. The array is
     * randomly created.
     * @return The time it took to ArraySum to succeed.
     */
    public static long timerForArraySum(int n, int max) {
        int[] arr = makeRandomArray(n, max);
        long startTime = System.nanoTime();

        ArraySum(arr);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Computes the maximum value of an array.
     * Complexity: time O(n), memory O(1)
     *
     * @param A A given array of ints.
     * @return The maximun value this array contains.
     */
    public static int ArrayMax(int[] A) {
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    /**
     * Computes the nanoseconds it took to get the max element inside an array
     * of length <code>n</code>, with a maximum possible value of
     * <code>max</code>.
     *
     * @param n The length of any array. It's the n in the BigO: "O(n)"
     * @param max The maximum value this array can contain. The array is
     * randomly created.
     * @return The time it took to ArrayMax to succeed.
     */
    public static long timerForArrayMax(int n, int max) {
        int[] arr = makeRandomArray(n, max);
        long startTime = System.nanoTime();

        ArrayMax(arr);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Sorts an array in ascendant order using Insertion Sort.
     * Complexity: time O(n^2), memory O(1).
     *
     * @param A The array to be sorted.
     */
    public static void InsertionSort(int[] A) {
        int temp, j;
        for (int i = 0; i < A.length; i++) {
            j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j = j - 1;
            }
        }
    }

    /**
     * Computes the nanoseconds it took to sort the elements inside an array of
     * length <code>n</code>, with a maximum possible value of <code>max</code>
     * USING INSERTION SORT.
     *
     * @param n The length of any array. It's the n in the BigO notation: "O(n)"
     * @param max The maximum value this array can contain. The array is
     * randomly created.
     * @return The time it took InsertionSort to succeed.
     */
    public static long timerForInsertionSort(int n, int max) {
        int[] arr = makeRandomArray(n, max);
        long startTime = System.nanoTime();

        InsertionSort(arr);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Sorts an array in ascendant order using Merge Sort.
     * Taken from www.cs.cmu.edu/
     * Complexity: time O(n*log(n)), memory O(n)
     *
     * @param a The array to be sorted.
     */
    public static void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left] <= a[right]) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }

        while (left <= leftEnd) // Copy rest of first half
        {
            tmp[k++] = a[left++];
        }

        while (right <= rightEnd) // Copy rest of right half
        {
            tmp[k++] = a[right++];
        }

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }

    /**
     * Computes the nanoseconds it took to sort an array of length
     * <code>n</code>, with a maximum possible value of <code>max</code> USING
     * MERGE SORT.
     *
     * @param n The length of any array. It's the n in the BigO: "O(n)"
     * @param max The maximum value this array can contain. The array is
     * randomly created.
     * @return The time it took to ArrayMax to succeed.
     */
    public static long timerForMergeSort(int n, int max) {
        int[] arr = makeRandomArray(n, max);
        long startTime = System.nanoTime();

        mergeSort(arr);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Runs a proofcase with different problem sizes for each method and prints
     * the results of n vs t(ns), for each one.
     *
     * @param args Nothing.
     */
    public static void main(String[] args) {
        int max = 5000;

        System.out.println("Times for arraySum");
        for (int i = 10000; i <= 100000000; i *= 10) {
            System.out.println("n = " + i + "t(ns) = " + timerForArraySum(i, max));
        }

        System.out.println("Times for arrayMax");
        for (int i = 10000; i <= 100000000; i *= 10) {
            System.out.println("n = " + i + "t(ns) = " + timerForArrayMax(i, max));
        }

        System.out.println("Times for insertionSort");
        for (int i = 0; i <= 100000; i += 10000) {
            System.out.println("n = " + i + "t(ns) = " + timerForInsertionSort(i, max));
        }

        System.out.println("Times for mergeSort");
        for (int i = 0; i <= 100000; i += 10000) {
            System.out.println("n = " + i + "t(ns) = " + timerForMergeSort(i, max));
        }
    }
}
