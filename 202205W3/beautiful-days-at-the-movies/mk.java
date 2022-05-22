import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Result {
    public static int reverseValue(int val) {
        String strVal = Integer.toString(val);

        String reverseVal = "";
        for(int i = strVal.length()-1; i >= 0; i--) {
            reverseVal += strVal.charAt(i);

        }

        return Integer.parseInt(reverseVal);
    }

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int result = 0;

        for(int val = i; val <= j; val ++) {
            if(val >= 0 && val <= 9) {
                result++;
                continue;
            }
            //System.out.println("val : " + val + ", reverse : " + reverseValue(val) + ", remain : "  + Math.abs(val - reverseValue(val)) % k);
            if(Math.abs(val - reverseValue(val)) % k  == 0){
                result++;
            }
        }

        return result;
    }
}


public class HackerRankTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
