import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int num = arr[i] = Integer.parseInt(st.nextToken());
            if(num > list.get(list.size()-1)) list.add(num); // 이전 입력값보다 크면 뒤에 추가
            else{
                int left = 0;
                int right = list.size()-1;
                int insertIdx = 0;
                while(left<=right){
                    int mid = (right+left)/2; // 인덱스 값
                    if(list.get(mid) >= num){ // 현재 입력값보다 mid번째 원소가 같거나 크면
                        // mid번째 원소를 작게 해야함
                        right = mid - 1;
                        insertIdx = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(insertIdx, num); // 넣어야 할 위치에 삽입
            }
        }
        System.out.println(list.size() - 1);
    }
}