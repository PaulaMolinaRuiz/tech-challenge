import java.util.ArrayList;
import java.util.Arrays;
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
        
        result.sort(Integer::compareTo);
        return result;
    }

    public static void main(String[] args) {
        int S = 6;
        int n = generateRandomN();

        int[] array = generateRandomArray(n);
        Arrays.sort(array); // Sorting the generated array
        System.out.print("Generated Sorted Array: ");
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
}
