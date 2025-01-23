import java.util.Arrays;

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
        int[] coins = {5, 7, 1, 1, 2, 3, 22};
        int result = nonConstructibleChange(coins);
        System.out.println(result);
    }
}
