import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[ n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 나무의 높이
        }
        Arrays.sort(arr);

        // 적어도 m미터의 나무를 가져가기 위한 절단기 높이 최댓값 구하기
        int left = 0;
        int right = arr[n-1];
        int answer = 0;
        while(left<=right){
            int mid = (right+left)/2; // 절단기 설정 높이
            long sum = 0;
            for(int height : arr){
                if(height > mid) sum += height - mid; // 절단기 설정 높이보다 나무의 높이가 크면 그 차이만큼을 집에 들고 감
            }
            if(sum < m){ // 집에 들고갈 수 있는 나무높이의 합이 m보다 작으면
                // 집에 들고갈 수 있는 나무높이의 합(나무 높이-절단기 높이)을 늘리기 위해
                right = mid-1; // 절단기 설정 높이를 낮춘다.
            }else{
                left = mid+1; // 절단기 설정 높이를 늘린다.
                answer = Math.max(answer, mid); // 최댓값 갱시
            }
        }
        System.out.println(answer);
        //System.out.println(right);
    }
}