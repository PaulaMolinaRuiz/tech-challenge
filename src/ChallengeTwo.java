import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of S:");
        int S = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter the numbers separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        
        List<Integer> result = sortedSquares(array, S);
        System.out.println("Result: " + result);
    }
}

