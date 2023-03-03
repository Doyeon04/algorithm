import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

         // 구해야하는 것: 모든 집을 칠하는 비용의 최솟값
        int[][] arr = new int[n + 1][3];
        int[][] dp = new int[n + 1][3]; // n번째 집을 c색상으로 칠하는데 필요한 최소 비용의 합
     
   
       // (i번 집색 != i-1번 집색, i+1번 집색) 
    
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

       // n번째 집까지 필요한 비용 - n번째 집이 각각 r, g, b 일 때 모두 구해 그 중 최솟값 구해야함
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]; // R
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1]; // G
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2]; // B
        }
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}