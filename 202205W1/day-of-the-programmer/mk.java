import java.io.*;


class Result {

    public static String dayOfProgrammer(int year) {
        // when leap year : 12/09/yyyy
        // when not leap year  : 13/09/yyyy
        // 1918 : 26/09/yyyy
        
        if(year == 1918) return "26.09." + Integer.toString(year);
        else
        {
            if((year < 1918 && year%4 == 0) || (year > 1918 && (year%400 == 0 || (year%4==0 && year%100 != 0)))) return "12.09." + Integer.toString(year);
            else return "13.09." + Integer.toString(year);
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
