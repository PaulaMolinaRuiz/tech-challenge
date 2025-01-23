import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChallengeOne {

    public static List<Integer> switchPositions(List<Integer> inputList, int S) {
        List<Integer> filteredList = new ArrayList<>();
        
        // Filter digits greater than or equal to S
        for (Integer num : inputList) {
            StringBuilder newNum = new StringBuilder();
            for (char digit : num.toString().toCharArray()) {
                if (Character.getNumericValue(digit) < S) {
                    newNum.append(digit);
                }
            }
            if (newNum.length() > 0) {
                filteredList.add(Integer.parseInt(newNum.toString()));
            }
        }
        
        // Reverse the list
        Collections.reverse(filteredList);
        return filteredList;
    }

    public static void main(String[] args) {
        int S = 9;
        int n = generateRandomN();

        System.out.println("Generated n: " + n);
        
        List<Integer> inputList = generateRandomNumbers(n);
        System.out.println("Generated List: " + inputList);
        
        List<Integer> result = switchPositions(inputList, S);
        System.out.println("Result: " + result);
    }

    public static int generateRandomN() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a random number between 1 and 100
    }

    public static List<Integer> generateRandomNumbers(int n) {
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            randomNumbers.add(random.nextInt(100));
        }
        
        return randomNumbers;
    }
}

