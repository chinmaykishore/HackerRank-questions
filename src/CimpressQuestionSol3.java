/*
You have to travel to different villages to make some profit
In each village, you gain some profit. But the catch is, from a particular village i, you can only move to a village j
if and only if i < j and the profit gain from village j is a multiple of the profit gain from village
You have to tell the maximum profit you can gain while traveling.

Input format
The first line contains a single integer N denoting the total number of villages.
The second line contains N space-separated integers, each denoting the profit gain
Output format
Print the maximum profit you can gain
 */

/*
Input
6
1 2 3 4 9 8
Output
not found
inserted= 1,1
found
oldsum= 1
newSum= 3
inserted= 2,3
removed= 1,1
not found
inserted= 3,3
found
oldsum= 3
newSum= 7
inserted= 4,7
removed= 2,3
found
oldsum= 3
newSum= 12
inserted= 9,12
removed= 3,3
found
oldsum= 7
newSum= 15
inserted= 8,15
removed= 4,7
15
Expected Correct Output
15
 */

/*
Input
4
2 3 6 9
Output
12
Expected Correct Output
12
 */

import java.util.HashMap;
import java.util.Scanner;

class CimpressQuestionSol3 {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        //String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        int N = s.nextInt();
        long[] arr = new long[N];
        for(int i=0;i<N;i++){
            arr[i] = s.nextLong();
        }
        HashMap<Long,Long> prevEleAndSum = new HashMap<>();
        //prevEleAndSum.put(arr[0],arr[0]);

        long maxprof = 0;//arr[0];
        for(int i=0;i<N;i++){
            //System.out.println("ele= "+arr[i]);
            if(arr[i]==0)
                continue;
            int found=0;
            long maxfoundKey = 0;
            for(long key: prevEleAndSum.keySet()){
                if(arr[i]%key == 0){
                    //System.out.println("found");
                    found =1;
                    long foundKey = key;
                    if(foundKey>maxfoundKey)
                        maxfoundKey=foundKey;

                }

            }
            if(found==1){
                long oldsum = prevEleAndSum.get(maxfoundKey);
                long newSum = oldsum +arr[i];
                //System.out.println("oldsum= "+oldsum);
                //System.out.println("newSum= "+newSum);

                prevEleAndSum.put(arr[i],newSum);
                //System.out.println("inserted= "+arr[i]+","+newSum);
                //prevEleAndSum.remove(maxfoundKey);
                //System.out.println("removed= "+maxfoundKey+","+oldsum);

                if(newSum>maxprof)
                    maxprof = newSum;
            }
            else if(found==0){
                //System.out.println("not found");
                prevEleAndSum.put(arr[i],arr[i]);
                //System.out.println("inserted= "+arr[i]+","+arr[i]);
                if(arr[i]>maxprof)
                    maxprof = arr[i];
            }

            //System.out.println("maxprof= "+maxprof);


        }

        System.out.println(maxprof);



        // Write your code here

    }
}
