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

        int[] coins = new int[n];
        int[] dp = new int[k+1]; // dp[i] = 금액 i를 만드는데 사용하는 동전의 경우의 수

        dp[0] = 1; // 0을 만드는데에는 경우가 1임

        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            for(int j=coins[i]; j<=k; j++){ // 동전의 금액부터 구하고자 하는 합까지 증가
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}