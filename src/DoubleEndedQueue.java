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
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        /*
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            list.add(num);
        }*/
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(2);

        int mostUniqueInAllSubArray  = calculateMostUniqueInAllSubArray(list);
        System.out.println(mostUniqueInAllSubArray);
    }
    public static int calculateMostUniqueInAllSubArray(List<Integer> list){

        for(int i=0;i<list.size();i++){

        }
        return 1;
    }
}
