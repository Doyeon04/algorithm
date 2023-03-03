import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10]; // dp[자리 수][앞에 오는 숫자]

        for(int i=1; i<10; i++){ // 0으로 시작하는 수는 계단수가 아님 
            dp[1][i] = 1; // 초기화
        }

	// 3자리 수 중 맨앞 숫자가 2인 경우는
	// 2자리 수 중 맨앞 숫자가 1인 경우 + 2자리 숫자 중 맨앞 숫자가 3인 경우의수
	// 210, 212, 232, 234

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                if(j==0){ // 0뒤에는 숫자 1만 올 수 있음 
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }
                else if(j==9){
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }
                else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++){
            answer+=dp[n][i];
        }
        System.out.println(answer % 1000000000);
    }
}