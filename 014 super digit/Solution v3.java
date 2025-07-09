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

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

     /*
      * We define super digit of an integer

using the following rules:

    If 

has only digit, then its super digit is
.
Otherwise, the super digit of
is equal to the super digit of the digit-sum of . Here, digit-sum of a number is defined as the sum of its digits. 
      */
    public static int superDigit(String n, int k) {
        long p=0;
        for(int i=0;i<n.length();i++)p+=Long.parseLong(n.substring(i, i+1));
        p*=k;
        return superDigit(p);
    }
    
    public static int superDigit(long p) {
        if(p<10)return (int)p;
        int sum=0;
        while(p>0){
            sum+=p%10;
            p/=10;
        }
        return superDigit(sum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
