import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    // Write your code here
    
        List<Integer> applesLoc = new ArrayList<Integer>();
        List<Integer> orangesLoc = new ArrayList<Integer>();
    
        int appleSize = apples.size();
        int orangeSize = oranges.size();
    
        for(int i = 0; i < appleSize; i++) {
            applesLoc.add(apples.get(i) + a);
        }
        
        for(int i = 0; i < orangeSize; i++) {
            orangesLoc.add(oranges.get(i) + b);
        }
    
        int appleCount = 0;
        int orangeCount = 0;
    
        for(int j = 0; j < appleSize; j++) {
            if(applesLoc.get(j) >= s && applesLoc.get(j) <= t) {
                appleCount ++;
            }      
        }

        for(int j = 0; j < orangeSize; j++) {
            if(orangesLoc.get(j) >= s && orangesLoc.get(j) <= t) {
                orangeCount ++;
            }        
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
