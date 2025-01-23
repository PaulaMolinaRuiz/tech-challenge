import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of S:");
        int S = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter the numbers separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();
        for (String s : input) {
            inputList.add(Integer.parseInt(s));
        }
        
        List<Integer> result = switchPositions(inputList, S);
        System.out.println("Result: " + result);
    }
}

