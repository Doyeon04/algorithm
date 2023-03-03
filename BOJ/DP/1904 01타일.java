import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        /*
        지금 있는 타일: 1, 00
        크기가 n인 2진 수열 만들자
        n=1 -> 1 (1개)
        n=2 -> 00, 11 (2개)
        n=3 -> 001, 100, 111 (3개)
        n=4 -> 0011, 1001, 1111 / n-1개에서 1더한것
            0000, 1100 / n-2개에서 00 더한 것
        (5개)
         */

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2]+dp[i-1]) % 15746;
        }
        System.out.println(dp[n] % 15746);
    }
}