import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    static class Point implements Comparable<Point>{
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o){ // 오름차순
            return this.cnt - o.cnt;
        }
    }

    public static void bfs(int x, int y){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(x, y, 0));

        arr[0][0] = -1;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x == n-1 && p.y == m-1){
                answer = p.cnt;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m || arr[nx][ny] == -1) continue;

                if(arr[nx][ny]==0){ // 방이면
                    arr[nx][ny] = -1;
                    queue.add(new Point(nx, ny, p.cnt));
                }
                if(arr[nx][ny] == 1){ // 벽이면
                    arr[nx][ny] = -1;
                    queue.add(new Point(nx, ny, p.cnt+1));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(answer);

    }
}