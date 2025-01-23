import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChallengeTwo {

    public static int[] sortedSquares(int[] array, int S) {
        int SS = S * S;
        List<Integer> result = new ArrayList<>();
        
        for (int num : array) {
            int square = num * num;
            if (square <= SS) {
                result.add(square);
            }
        }
        
        // Convert ArrayList to primitive int array
        int[] array2 = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array2[i] = result.get(i);
        }

        mergeSortArray(array2);
        return array2;
    }

    public static void main(String[] args) {
        int S = 9;
        int n = generateRandomN();

        int[] array = generateRandomArray(n);
        // Sort the generated array using custom merge sort
        array = mergeSortArray(array);
        System.out.print("Generated Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result = sortedSquares(array, S);
        System.out.println("Result: " );
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int generateRandomN() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a random number between 1 and 100
    }

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] randomArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            // Generate random integers in the range -100 to 100
            randomArray[i] = random.nextInt(201) - 100;
        }
        
        return randomArray;
    }

    private static int[] mergeSortArray(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        
        mergeSortArray(left);
        mergeSortArray(right);
        
        return mergeArrays(array, left, right);
    }

    private static int[] mergeArrays(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }
        
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
        
        return result;
    }
}
