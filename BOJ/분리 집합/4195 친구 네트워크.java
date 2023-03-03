import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static int[] unf;

    static int[] level;
    static StringBuilder sb = new StringBuilder();
    public static int find(int v){
        if(v==unf[v]) return v;
        return unf[v] = find(unf[v]);
    }
    public static int union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb) {
            unf[fa] = fb;
            level[fb] += level[fa]; // fa에 있던 층의 개수를 더해줌
        }
        return level[fb];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int F = Integer.parseInt(br.readLine()); // 친구 관계의 수

            int id = 1;

            unf = new int[2*F+1];
            level = new int[2*F+1];
            for(int i=1; i<2*F+1; i++){
                unf[i] = i;
                level[i] = 1;
            }

            HashMap<String, Integer> map = new HashMap<>();

            for(int i=1; i<=F; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                if(!map.containsKey(name1)) map.put(name1, id++);

                String name2 = st.nextToken();
                if(!map.containsKey(name2)) map.put(name2, id++);

                sb.append(union(map.get(name1), map.get(name2))).append("\n");
            }
        }
        System.out.println(sb);
    }
}