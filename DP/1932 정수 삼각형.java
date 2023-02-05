import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1]; // i, j 까지의 합의 최댓값

        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
     // 그 전 선택된 수는 대각선 왼쪽 위거나 오른쪽 위가 될 수 있고 이 중 큰 값을 구해 다음 수를 더해야됨

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer, dp[n][i]);
        }
        System.out.println(answer);

    }
}