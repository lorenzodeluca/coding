import java.util.*;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> notes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (notes.get(tmp) != null) {
                return new int[]{notes.get(tmp), i};
            }
            notes.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensione array
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Input elementi array
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target
        int target = scanner.nextInt();

        // Chiamata al metodo
        int[] result = twoSum(nums, target);

        // Output risultato
        if (result.length == 2) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("No solution found");
        }

        scanner.close();
    }
}