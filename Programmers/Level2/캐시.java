/*
jeju -m
jeju pangyo -m
pangyo newyork -m
pangyo newyork -h
---> 16

1. 캐시 히트라면 
    1-1. 해당 자리에 있는 원소 지우고 맨 뒤에 추가
2. 캐시 미스라면
    2-1. 캐시 크기가 꽉 찼다면 첫번째 원소 지우고 맨 뒤에 추가 
    2-2. 캐시 크기 안찼다면 그냥 맨 뒤에 추가 
*/

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return cities.length * 5; 
        }
        List<String> list = new ArrayList<>();     
        
        for(String city : cities){
            city = city.toLowerCase(); 
            
            if(list.contains(city)){ // 1
                answer++;
                list.remove(city);
                list.add(city); 
            }else{ // 2
                 answer+=5;
                if(list.size() == cacheSize){
                    list.remove(0);
                }
                list.add(city);
            }
        }
        return answer;
    }
}
