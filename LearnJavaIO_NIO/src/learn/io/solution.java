package learn.io;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class SortByelt implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[2]-o2[2];
    }
}

public class solution {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1},{100,150,200,300}, {25}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new SortByelt());
        int i;
        for(i=0; i<3; i++){
            pq.add(new int[]{i, 0, arr[i][0]});
        }
        int[] ans = new int[6];
        int j = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            ans[j++] = temp[2];
            if (arr[temp[0]].length > temp[1]+1){
                pq.add(new int[]{temp[0], temp[1]+1, arr[temp[0]][temp[1]+1]});
            }
        }
        Arrays.stream(ans).forEach(val -> System.out.print(val+" "));
    }

}
