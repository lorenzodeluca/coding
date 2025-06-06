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
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        boolean turn = false; //false=1, true=2
        List<Integer> tower = new ArrayList<Integer>();
        for(int ncopy=n;ncopy>0;ncopy--){
            tower.add(m);
        }
        while(tower.stream().mapToInt(Integer::intValue).max().getAsInt()>1){
            System.out.println("debug"+n+"-"+m+"-"+(turn?"2":"1")+"->"+tower);
            //mcd
            int highestIndex= tower.indexOf(tower.stream().mapToInt(Integer::intValue).max().getAsInt());
            int height=tower.stream().mapToInt(Integer::intValue).max().getAsInt();
            int mcd = height/2;
            while(height%mcd!=0)mcd--;
            if(mcd==1||tower.stream().filter(z->z>1).count()==1)mcd=height;
            tower.set(highestIndex, height/mcd);
            turn = !turn;
        }
        System.out.println("debug"+n+"-"+m+"-"+(turn?"true":"false")+"->"+tower);
        return turn?1:2;
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

                int result = Result.towerBreakers(n, m);

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
