import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집의 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기의 개수

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 가장 인접한 두 공유기 사이의 최대 거리

        int left = 1; // 가능한 최소 거리
        int right = arr[n-1] - arr[0]; // 가능한 최대 거리
        int answer = 0;

        while(left<=right){
            int mid = (left+right) / 2; // 기준 간격(가장 인접한 두 공유기 사이의 거리)
            int start = arr[0];

            int cnt = 1; // 공유기 개수
            for(int i=1; i<n; i++){ // 기준 간격으로 공유기 설치
                int gap = arr[i] - start;
                if(gap >= mid){
                    cnt++;
                    start = arr[i];
                }
            }
            if(cnt >= c){ // 설치해야할 공유기 개수보다 많이 설치함 -> 최대 거리 찾기 위해 거리를 늘림
                answer = mid;
                left = mid + 1;
            }else{ // 적게 설치함 -> 거리를 줄임
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}