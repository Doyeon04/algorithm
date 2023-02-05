
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int MOD = 10007;

        int[][] dp = new int[n+1][10];

       for(int i=0; i<10; i++){
           dp[1][i] = 1;
       }
       for(int i=1; i<=n; i++){
           dp[i][0] = 1;
       }
     // 3자리 수 중 4로 끝나는 수
    // 2자리 수 0으로 끝나는 수 + 2자리수 1로 끝나는 수 + 2자리수 2로~ + 2자리수 4로~
    // dp[3][4] = dp[2][0]부터 dp[2][4] 까지의 합 
    // ==> dp[i][j] = dp[i-1][0] 부터 dp[i-1][j] 까지의 합
    // dp[i][j-1]은 dp[i-1][0] 부터 dp[i-1][j-1]까지의 합과 같다. 
    // 즉 dp[i][j] = dp[i][j-1] + dp[i-1][j] 

       for(int i=2; i<=n; i++){
           for(int j=1; j<10; j++){
               dp[i][j] = dp[i][j-1] + dp[i-1][j] % MOD;
           }
       }
       int answer = 0;
        for(int i=0; i<10; i++){
            answer += dp[n][i];
        }
        System.out.println(answer % MOD);
    }
}