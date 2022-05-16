import java.io.*;


class Result {


    public static int pageCount(int n, int p) {
        
        if(p == 0 || p == n) return 0;
        
        int half = n/2;
        
        if(p <= half) return p/2;
        else {
            if(n%2 == 0) return ((n-p)/2) + ((n-p)%2);
            else return (n-p)/2;
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
