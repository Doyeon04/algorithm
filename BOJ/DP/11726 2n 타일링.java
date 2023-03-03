import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
     // dp[n-1] 사각형에 세로 직사각형 하나 추가
     // dp[n-2] 사각형에 가로 직사각형 두개 추가
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
            dp[i]%=10007;
        }

        System.out.println(dp[n]);
    }
}