import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Integer> inputList = List.of(1, 2, 3, 4, 5, 6);
        int S = 6;
        List<Integer> result = switchPositions(inputList, S);
        System.out.println(result);
    }
}
