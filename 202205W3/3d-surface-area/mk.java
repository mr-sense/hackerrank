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

    public static int removeArea(int[][] numArray, int i, int j, int h, int w){
        int removeSum = 0;
        int target = numArray[i][j];

        if(i != 0) {
            removeSum += (numArray[i-1][j] > target) ? target : numArray[i-1][j];
        }
        if(i != h-1) {
            removeSum += (numArray[i+1][j] > target) ? target : numArray[i+1][j];
        }

        if(j != 0) {
            removeSum += (numArray[i][j-1] > target) ? target : numArray[i][j-1];
        }
        if(j != w-1) {
            removeSum += (numArray[i][j+1] > target) ? target : numArray[i][j+1];
        }

        return removeSum;

    }


    public static int surfaceArea(List<List<Integer>> A) {
        int total = 0;
        int val = 0;
        int h = A.size();
        int w = 0;
        int [][] numArray = new int[h][];

        for(int i = 0; i < h; i++) {
            List<Integer> list = A.get(i);
            numArray[i] = new int[list.size()];
            for(int j = 0; j < list.size(); j++) {
                val = list.get(j);
                numArray[i][j] = val;
                total += (val*6)-(2*(val-1));
            }
        }

        int removeArea = 0;
        for(int i = 0; i < h; i++) {
            w = numArray[i].length;
            for(int j = 0; j < w; j++) {
                removeArea += removeArea(numArray, i, j, h, w);
            }
        }

        return total - removeArea;
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
