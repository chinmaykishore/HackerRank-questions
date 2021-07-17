/*
Sample Input

6 3
5 3 5 2 2 2
Sample Output

3
Explanation

In the sample testcase, there are 4 subarrays of contiguous numbers.
 (5,3,5)- Has 2 unique numbers.
 (3,5,2)- Has 3 unique numbers.
 (5,2,2)- Has 2 unique numbers.
 (2,2,2)- Has 1 unique numbers.

In these subarrays, there are 2,3,2,1 unique numbers, respectively.
The maximum amount of unique numbers among all possible contiguous subarrays is 3.

 */
import java.util.*;
public class DoubleEndedQueue {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        int m =3;// in.nextInt();
        int[] arr = {5,3,5,2,2,2};
        //int[] arr = {5,5,2,2,2,5};
        /*
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

        }*/
        int mostUniqueInAllSubArray  = calculateMostUniqueInAllSubArray(arr,m);
        System.out.println(mostUniqueInAllSubArray);
    }
    public static int calculateMostUniqueInAllSubArray(int[] arr,int m){

        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> hs = new HashSet<>();
        int first;
        int maxunique=0;
        for(int i=0;i<arr.length;i++){
            int ele = arr[i];
            deque.addLast(ele);
            hs.add(ele);
            if(deque.size()== m){
                if(hs.size() > maxunique)
                    maxunique = hs.size();
                first = deque.removeFirst();
                System.out.println("first="+first);
                if(!deque.contains(first))
                    hs.remove(first);
            }
        }
        return maxunique;
    }
}
