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
    static int[] radius;
    static int[][] sparse;
    static int[] log;
public static List<Integer> circularPalindromes(String s) {
        int n = s.length();

        String doubled = s + s;

        int length = doubled.length() * 2 + 1;

        int[] a = new int[length];

        for (int i = 0; i < length; i++) {

            if (i % 2 == 0) {
                a[i] = -1;
            } else {
                a[i] = doubled.charAt(i / 2);
            }
        }

        radius = new int[length];

        int center = 0;
        int right = 0;

        for (int i = 0; i < length; i++) {

            if (i < right) {
                radius[i] = Math.min(
                    radius[2 * center - i],
                    right - i
                );
            } else {
                radius[i] = 0;
            }

            while (
                i - radius[i] - 1 >= 0 &&
                i + radius[i] + 1 < length &&
                a[i - radius[i] - 1] == a[i + radius[i] + 1]
            ) {
                radius[i]++;
            }

            if (i + radius[i] > right) {
                center = i;
                right = i + radius[i];
            }
        }

        buildSparseTable();

        List<Integer> result = new ArrayList<>();

        for (int start = 0; start < n; start++) {

            int left = 2 * start + 1;
            int rightEnd = 2 * (start + n - 1) + 1;

            int low = 1;
            int high = n;
            int answer = 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (canFind(left, rightEnd, mid)) {
                    answer = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            result.add(answer);
        }

        return result;
    }

    static boolean canFind(int left, int right, int len) {

        int queryLeft = left + len - 1;
        int queryRight = right - len + 1;

        if (queryLeft > queryRight) {
            return false;
        }

        return getMax(queryLeft, queryRight) >= len;
    }

    static void buildSparseTable() {

        int n = radius.length;

        log = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int levels = log[n] + 1;

        sparse = new int[levels][n];

        for (int i = 0; i < n; i++) {
            sparse[0][i] = radius[i];
        }

        for (int j = 1; j < levels; j++) {

            int size = 1 << j;

            for (int i = 0; i + size <= n; i++) {

                sparse[j][i] = Math.max(
                    sparse[j - 1][i],
                    sparse[j - 1][i + (size >> 1)]
                );
            }
        }
    }

    static int getMax(int left, int right) {

        if (left > right) {
            return 0;
        }

        int length = right - left + 1;
        int j = log[length];

        return Math.max(
            sparse[j][left],
            sparse[j][right - (1 << j) + 1]
        );
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
