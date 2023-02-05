import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        dp[1] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

// a+b = n이라고 할 때, 
// 카드 i개를 사기위한 최대 금액 dp[a]와 b개짜리 카드팩 값을 더한 값의 최댓값
      
        for(int i=1; i<=n; i++){
            for(int j=i; j>=1; j--){ 
                dp[i] = Math.max(dp[i], dp[i-j]+arr[j]);
            }
        }
        System.out.println(dp[n]);
    }
}