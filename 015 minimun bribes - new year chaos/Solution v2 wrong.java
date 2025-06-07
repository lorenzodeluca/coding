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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int bribesNum = 0;
        Map<Integer,Integer> bribers=new HashMap<>();
        for(int pos=0;pos<q.size()-1;pos++){
            if(q.get(pos)>q.get(pos+1)){
                bribesNum++;
                if(bribers.containsKey(q.get(pos)))bribers.put(q.get(pos), bribers.get(q.get(pos))+1);
                else bribers.put(q.get(pos), 1);
                int tmp=q.get(pos);
                q.set(pos, q.get(pos+1));
                q.set(pos+1, tmp);
                pos=0; //<- sbagliato possibile ricorsione infinita
            }
        }
        for(Map.Entry<Integer,Integer> entry: bribers.entrySet()){
            if(entry.getValue()>2){
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(bribesNum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
