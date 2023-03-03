import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];
        int[][] B = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                A[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                B[i][j] = str.charAt(j) - '0';
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i+3>n || j+3>m || A[i][j] == B[i][j]) continue;

                for(int r= i; r<i+3; r++){
                    for(int c=j; c<j+3; c++){
                        A[r][c] = 1-A[r][c];
                    }
                }
                cnt++;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i][j] != B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }
}