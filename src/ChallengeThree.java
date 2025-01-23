import java.util.Arrays;
import java.util.Random;

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
        int n = generateRandomN();
        int[] coins = generateRandomArray(n);
        
        System.out.print("Generated Array: ");
        for (int coin : coins) {
            System.out.print(coin + " ");
        }
        System.out.println();
        
        int result = nonConstructibleChange(coins);
        System.out.println("Minimum Amount of Change You Cannot Give: " + result);
    }

    public static int generateRandomN() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a random number between 1 and 100
    }

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] randomArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            randomArray[i] = random.nextInt(100) + 1; // Generates random coins with values between 1 and 50
        }
        
        return randomArray;
    }
}

