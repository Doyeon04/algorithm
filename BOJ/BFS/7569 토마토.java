import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n, m, h;
    static int[][][] arr;
    static Queue<Point> queue = new LinkedList<>();
    // 위, 아래, 상, 하, 좌, 우
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    static class Point{
        int x, y, z;
        public Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static void bfs(){
        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0; i<6; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n || nz<0 || nz>=h) continue;

                if(arr[nz][ny][nx] == 0){ // 아직 안익은 토마토면;
                    arr[nz][ny][nx] = arr[p.z][p.y][p.x] + 1;
                    queue.add(new Point(nx, ny, nz));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];

        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == 1) { // 익은 토마토면
                        queue.add(new Point(j, i, k));
                    }
                }
            }
        }

        bfs();

        int day = Integer.MIN_VALUE;
        for(int k=0; k<h; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[k][i][j]==0){ // 익지 않은 토마토가 남아있다면
                        System.out.println(-1);
                        return;
                    }
                    else day = Math.max(day, arr[k][i][j]); // 최댓값이 토마토가 익는데 총 걸리는 일수
                }
            }
        }
        System.out.println(day-1);
    }
}