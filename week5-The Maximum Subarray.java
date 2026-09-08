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

    

    public static List<Integer> maxSubarray(List<Integer> arr) {
    
        int maxSubarray = arr.get(0);
    int currentSum = arr.get(0);

    int maxSubsequence = 0;
    int maxElement = arr.get(0);

    for (int i = 0; i < arr.size(); i++) {
        int num = arr.get(i);

        if (num > 0) {
            maxSubsequence += num;
        }

        maxElement = Math.max(maxElement, num);

        if (i > 0) {
            currentSum = Math.max(num, currentSum + num);
            maxSubarray = Math.max(maxSubarray, currentSum);
        }
    }

    if (maxSubsequence == 0) {
        maxSubsequence = maxElement;
    }

    return Arrays.asList(maxSubarray, maxSubsequence);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}