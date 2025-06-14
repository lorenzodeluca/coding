import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    // to prevent overflow, the limit is set by the problem specifics
    private static final long MOD = 1000000007;
    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n wall heigth
     *  2. INTEGER m wall width
     */
    public static int legoBlocks(int n, int m) {
        // if the wall is tall 1, for it to be solid it must be 1 unique block 
          if (n == 1) {
            return m < 5 ? 1 : 0;
        }
        
        //ways of building one row
        //permutation[1] tell me the number of ways i can build a row of width 1
        long[] permutation = new long[m + 1];
        //examples
        //permutation[1]=1(1 block of width 1=1x1 block(1x1 = CxW = count of blocks x width))
        for (int i = 1; i <= m; i++) {
            if (i < 5) {
                //this if is a fancy way of writing:
                //permutation[1] = 1       
                // permutation[2] = permutation[1] + 1   
                //permutation[3] = permutation[2] + permutation[1] + 1  
                permutation[i] = 1;
                for (int j = i - 1; j >= 1; j--) {
                    permutation[i] += permutation[j];
                    permutation[i] %= MOD;
                }
            } else { 
                //the count of how many ways i can build a wall up to a point can be simplified 
                //considering the ways i can build a wall of i-1 width... 
                // since i only have 4 different blocks i only need to consider the previous 4 permutations
                permutation[i] = permutation[i - 1] + permutation[i - 2] + permutation[i - 3] + permutation[i - 4];
                permutation[i] %= MOD;
            }
        }
        //ways of building a ways to build a wall of n rows
        // for now i dont check if the wall is "solid"
        long[] total = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            total[i] = 1;
            for (int j = 1; j <= n; j++) {
                total[i] *= permutation[i];
                total[i] %= MOD;
            }
        }
        //now i check of all the possible ways to build a wall how many are "solid"
        long[] good = new long[m + 1];
        good[1] = 1;
        long[] bad = new long[m + 1];
        bad[1] = 0;
        for (int i = 2; i <= m; i++) {
            bad[i] = 0;
            for (int j = 1; j < i; j++) {
                bad[i] += good[j] * total[i - j];
                bad[i] %= MOD;
            }
            good[i] = (total[i] - bad[i] + MOD) % MOD;
        }
        return (int)good[m];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
