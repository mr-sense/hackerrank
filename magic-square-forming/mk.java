import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int formingMagicSquare(List<List<Integer>> s) {
        int abs = 100;

        // all cases
        int[][] c1 = {{2,9,4},{7,5,3},{6,1,8}};
        int[][] c2 = {{2,7,6},{9,5,1},{4,3,8}};
        int[][] c3 = {{8,1,6},{3,5,7},{4,9,2}};
        int[][] c4 = {{8,3,4},{1,5,9},{6,7,2}};
        int[][] c5 = {{4,9,2},{3,5,7},{8,1,6}};
        int[][] c6 = {{4,3,8},{9,5,1},{2,7,6}};
        int[][] c7 = {{6,7,2},{1,5,9},{8,3,4}};
        int[][] c8 = {{6,1,8},{7,5,3},{2,9,4}};

        List<int[][]> c = new ArrayList<int[][]>();
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        c.add(c6);
        c.add(c7);
        c.add(c8);

        List<Integer> sList = new ArrayList<Integer>();
        int [][] cArray;
        int listVal = 0;
        int caseVal = 0;
        int tempAbs = 0;

        for(int k = 0; k < c.size(); k++) {
            cArray = c.get(k);
            tempAbs = 0;
            for(int i = 0; i < 3; i++) {
                sList = s.get(i);
                for(int j = 0; j < 3; j++) {
                    listVal = sList.get(j);
                    caseVal = cArray[i][j];

                    if(listVal == caseVal) continue;
                    tempAbs += Math.abs(listVal - caseVal);

                }
            }
            if(abs > tempAbs) abs = tempAbs;
            if(abs == 0) break;
        }
        
        return abs;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
