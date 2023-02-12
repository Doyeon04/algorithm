import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int card[] = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int num =Integer.parseInt(st.nextToken());

            int answer=0;
            int start=0, end=n-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(card[mid]==num){
                    answer=1;
                    break;
                }
                if(card[mid]>num) end=mid-1;
                else start=mid+1;
            }
            sb.append(answer+" ");
        }
        System.out.println(sb);
    }
}