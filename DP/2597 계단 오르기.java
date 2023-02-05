import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[301];
        int[] dp = new int[301]; // n번째 계단을 밟을 때 점수의 최댓값

        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1]; // 1번째 계단 밟을 때 점수
        dp[2] = arr[1] + arr[2]; // 2번째 계단 밟을 때 점수 최댓값 

//n번째 계단을 밟는 경우의 수는
//n-3번째 계단 -> n-1번째 계단 -> n번째 계단
//n-2번째 계단 -> n번째 계단
// 두가지 경우중 점수의 최댓값 dp 에 저장

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
        }
        System.out.println(dp[n]);
    }
}