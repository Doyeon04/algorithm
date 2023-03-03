import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; // i를 1로 만들 때 연산을 하는 횟수의 최솟값

        dp[1] = 0;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1; // +1 연산 수행한 횟수
            if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]+1); // 3을 나눴을 때와 1을 뺐을때 연산 최솟값 비교
            if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]+1); // 2를 나눴을 때와 1을 뺐을 때 연산 최솟값 비교
        }
        System.out.println(dp[n]);
    }
}