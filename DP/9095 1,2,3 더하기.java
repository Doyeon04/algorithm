import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static int[] dp = new int[11]; 
    public static int solution(int n){
        dp[1] = 1;
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3 

/*
4
1 + dp[3] 4가지
2 + dp[2] 2가지
3 + dp[1] 1가지
*/

        for(int i=4; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(solution(n));
        }
    }
}