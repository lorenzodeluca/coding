import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

  /*
   * Complete the 'truckTour' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
   */

  public static int truckTour(List<List<Integer>> petrolpumps) {
    int startingPump = 0;
    int distance = 0;
    int currentPump = 0;
    int pumpsVisited = 0;
    int n = petrolpumps.size();

    while (pumpsVisited < n) {
      distance +=
        petrolpumps.get(currentPump).get(0) -
        petrolpumps.get(currentPump).get(1);
      if (distance < 0) {
        // riparti dalla prossima stazione
        startingPump = currentPump + 1;
        pumpsVisited = 0;
        distance = 0;
      } else {
        pumpsVisited++;
      }
      currentPump = (currentPump + 1) % n;
      // Se startingPump supera l'ultimo indice, allora non c'e soluzione
      if (startingPump >= n) return -1;
    }
    return startingPump;
  }
}

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    BufferedWriter bufferedWriter = new BufferedWriter(
      new FileWriter(System.getenv("OUTPUT_PATH"))
    );

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> petrolpumps = new ArrayList<>();

    IntStream
      .range(0, n)
      .forEach(i -> {
        try {
          petrolpumps.add(
            Stream
              .of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
              .map(Integer::parseInt)
              .collect(toList())
          );
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      });

    int result = Result.truckTour(petrolpumps);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
