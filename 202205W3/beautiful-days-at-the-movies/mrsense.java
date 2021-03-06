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

    public static int getReverseInteger(int num) {
        String numString = num + "";
        String[] numStringSplit = numString.split("");
        String reverseString = "";
        for (int i=numStringSplit.length-1; i >= 0; i--) {
            reverseString += numStringSplit[i];
        }
        
        return Integer.parseInt(reverseString);
    }

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */
    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int totalBeautifulDays = 0;
        for (int z=i; z<=j; z++) {
            //TODO 한자리 수의 역은 같은 값이므로 역을 계산할 필요가 없다
            
            int beautifulNum = Math.abs(z - getReverseInteger(z));
            if (beautifulNum % k == 0) {
                totalBeautifulDays++;
            }
        }

        return totalBeautifulDays;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
