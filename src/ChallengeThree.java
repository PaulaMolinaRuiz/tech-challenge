import java.util.Arrays;
import java.util.Scanner;

public class ChallengeThree {

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated = 0;
        
        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) {
                break;
            }
            currentChangeCreated += coin;
        }
        
        return currentChangeCreated + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the coin values separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] coins = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            coins[i] = Integer.parseInt(input[i]);
        }
        
        int result = nonConstructibleChange(coins);
        System.out.println("Minimum amount of change you cannot give: " + result);
    }
}

