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
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */
    public static String convertString(int n) {
        switch (n) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
//            case 15:
//                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            case 21:
                return "twenty " + convertString(1);
            case 22:
                return "twenty " + convertString(2);
            case 23:
                return "twenty " + convertString(3);
            case 24:
                return "twenty " + convertString(4);
            case 25:
                return "twenty " + convertString(5);
            case 26:
                return "twenty " + convertString(6);
            case 27:
                return "twenty " + convertString(7);
            case 28:
                return "twenty " + convertString(8);
            case 29:
                return "twenty " + convertString(9);
        }

        return "";
    }

    public static String getHour(int h) {
        if (h > 12) {
            return convertString(h - 12);
        } else {
            return convertString(h);
        }
    }

    public static String getMinute(int m) {
        if (m == 1) {
            return convertString(m) + " minute";
        } else {
            return convertString(m) + " minutes";
        }
    }

    public static String timeInWords(int h, int m) {
        // Write your code here
        if ( m == 0 ) {
            return getHour(h) + " o' clock";
        } else if ( m == 15 ) {
            return "quarter past " + getHour(h);
        } else if ( m == 30 ) {
            return "half past " + getHour(h);
        } else if ( m == 45 ) {
            return "quarter to " + getHour(h+1);
        } else {
            if (m > 30) {
                return getMinute(60 - m) + " to " + getHour(h+1);
            } else {
                return getMinute(m) + " past " + getHour(h);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
