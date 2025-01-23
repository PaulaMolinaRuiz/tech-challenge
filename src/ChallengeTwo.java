import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChallengeTwo {

    public static List<Integer> sortedSquares(int[] array, int S) {
        int SS = S * S;
        List<Integer> result = new ArrayList<>();
        
        for (int num : array) {
            int square = num * num;
            if (square <= SS) {
                result.add(square);
            }
        }
        
        mergeSort(result, 0, result.size() - 1);
        return result;
    }

    private static void mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private static void merge(List<Integer> list, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        
        for (int i = 0; i < n1; i++) {
            leftList.add(list.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(list.get(mid + 1 + j));
        }
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftList.get(i) <= rightList.get(j)) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }
        
        while (j < n2) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int S = 6;
        int n = generateRandomN();

        int[] array = generateRandomArray(n);
        // Sort the generated array using custom merge sort
        array = mergeSortArray(array);
        System.out.print("Generated and Sorted Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        List<Integer> result = sortedSquares(array, S);
        System.out.println("Result: " + result);
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
