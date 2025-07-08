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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     * {(([])[])[]}[]
     */
    
    public static boolean match(char a, char b){
        if(a=='{'&&b=='}')return true;
        if(a=='['&&b==']')return true;
        if(a=='('&&b==')')return true;
        return false;
    }
    
    public static String isBalanced(String s) {
        List<Character> input=new ArrayList<>(); 
        for(int i =0;i<s.length();i++)input.add(s.charAt(i));
        boolean somethingChanged=true;
        while(!input.isEmpty()){
            if(!somethingChanged)return "NO";
            somethingChanged=false;
            for(int i =0;i<input.size()-1;i++){
                if(match(input.get(i), input.get(i+1))){
                    input.remove(i);
                    input.remove(i);
                    somethingChanged=true;
                }
            }
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
