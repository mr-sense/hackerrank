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
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here
        int sumOfSurface = 0;

        int row = A.size();
        int height = A.get(0).size();

        // get top and bottom
        sumOfSurface = 2 * row * height;

        // get front
        for (int i = 0; i < row; i++) {
            int maxVal = 0;
            for (int j = 0; j < height; j++) {
                int currentVal = A.get(i).get(j);
                if (currentVal > maxVal) {
                    sumOfSurface += currentVal - maxVal;
                }

                maxVal = currentVal;
            }
        }

        // get right
        for (int i = 0; i < height; i++) {
            int maxVal = 0;
            for (int j = 0; j < row; j++) {
                int currentVal = A.get(j).get(i);
                if (currentVal > maxVal) {
                    sumOfSurface += currentVal - maxVal;
                }

                maxVal = currentVal;
            }
        }

        // get back
        for (int i = 0; i < row; i++) {
            int maxVal = 0;
            for (int j = height-1; j >= 0; j--) {
                int currentVal = A.get(i).get(j);
                if (currentVal > maxVal) {
                    sumOfSurface += currentVal - maxVal;
                }

                maxVal = currentVal;
            }
        }

        // get left
        for (int i = 0; i < height; i++) {
            int maxVal = 0;
            for (int j = row-1; j >= 0; j--) {
                int currentVal = A.get(j).get(i);
                if (currentVal > maxVal) {
                    sumOfSurface += currentVal - maxVal;
                }

                maxVal = currentVal;
            }
        }

        return sumOfSurface;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
