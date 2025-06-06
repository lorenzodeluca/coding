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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String time = s.substring(0, s.length()-2);
        String ampm = s.substring(s.length()-2 , s.length());
        List<String> hhmmss = new ArrayList<>(Arrays.asList(time.split(":")));
        int hh = Integer.parseInt(hhmmss.get(0));
        int mm = Integer.parseInt(hhmmss.get(1));
        int ss = Integer.parseInt(hhmmss.get(2));
        if(ampm.equals("PM") && hh!=12)hh+=12;
        else if(ampm.equals("AM") && hh==12)hh=0;
        DecimalFormat f = new DecimalFormat("00");
        return f.format(hh)+":"+f.format(mm)+":"+f.format(ss);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();
        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
