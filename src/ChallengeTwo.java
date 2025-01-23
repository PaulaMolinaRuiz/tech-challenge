import java.util.ArrayList;
import java.util.List;

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
        int[] array = {1, 2, 3, 5, 6, 8, 9};
        int S = 6;
        List<Integer> result = sortedSquares(array, S);
        System.out.println(result);
    }
}
