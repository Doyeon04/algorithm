import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[201][201];

// n = 4, k = 3 (0~4까지의 숫자 중 3개의 합이 4가 되는 경우의 수)
// 2개의 숫자로 만든 합 + 0부터 4까지의 숫자 중 하나

// 0을 2개의 숫자로 만드는 경우의 수 (마지막에 4더한 경우)
// 1을 2개의 숫자로 ~ (3)
// 2를 2개의 숫자로 ~ (2)
// ...
// => dp[n][k] = dp[0][k-1] + dp[1][k-1] + .... + dp[n][k-1]
// dp[i-1][j] = dp[0][j-1] 부터 dp[i-1][j-1] 까지 더한 값
// ===> dp[i][j] = dp[i-1][j] + dp[i][j-1] 

        for(int i=0; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(j==1 || i==0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1] % 1000000000;
            }
        }

        System.out.println(dp[n][k] % 1000000000);
    }
}