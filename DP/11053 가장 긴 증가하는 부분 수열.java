import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n]; // 부분 수열 길이를 저장할 배열
        dp[0] = 1;
        int answer = dp[0];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){ // i값 이전의 값들 탐색
                if(arr[j]<arr[i] && dp[j] > max) max = dp[j]; // i값 보다 작고 max 값 보다 크다면 최대수열길이 갱신
            }
            dp[i] = max+1; // 수열길이 1증가
            answer = Math.max(answer, dp[i]); // 가장 긴 길이 갱신
        }
        System.out.println(answer);
    }
}