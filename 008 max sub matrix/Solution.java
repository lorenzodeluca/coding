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
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n2=matrix.size(); //2*n
        int n=matrix.size()/2;
        
        List<Integer> nToSum = new ArrayList<Integer>();
        
        //for each position of the submatrix i find the highest number that can go there
        for(int r=0,c=0;r<n&&c<n;){//row column of the submatrix
            //i find all the numbers that could go in that cell
            List<Integer> poss=new ArrayList<Integer>();
            //top-left
            poss.add(matrix.get(r).get(c));
            //top-right
            poss.add(matrix.get(r).get(n2-1-c));
            //bottom-right
            poss.add(matrix.get(n2-1-r).get(n2-1-c));
            //bottom-left
            poss.add(matrix.get(n2-1-r).get(c));
            nToSum.add(poss.stream().max(Comparator.naturalOrder()).get());
                
            c++;
            if(c==n){
                c=0;
                r++;    
            }
        }
        
        return nToSum.stream().mapToInt(Integer::intValue).sum();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.flippingMatrix(matrix);

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
