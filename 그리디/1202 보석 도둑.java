import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static class Jewel implements Comparable<Jewel>{
        int weight, price;
        public Jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
        @Override
        public int compareTo(Jewel j){
            return this.weight - j.weight; // 무게 오름차순
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 보석의 총 개수
        int k = Integer.parseInt(st.nextToken()); // 가방의 개수

        ArrayList<Jewel> jewels = new ArrayList<>(); // 보석 정보
        ArrayList<Integer> bags = new ArrayList<>(); // 가방에 담을 수 있는 최대 무개

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }
        for(int i=0; i<k; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(jewels); // 보석 무게 오름차순 정렬
        Collections.sort(bags); // 가방 무게 오름차순 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder()); // 가격 내림차순

        long answer = 0;
        int index=0;
        for(int bag : bags){
            while(index< n && jewels.get(index).weight <= bag){
                queue.offer(jewels.get(index++).price);
            }
            if(!queue.isEmpty()) {
                answer+= queue.poll(); // 큐의 맨앞의 원소(보석의 가장 높은 가격)을 더함
            }
        }
        System.out.println(answer);
    }
}