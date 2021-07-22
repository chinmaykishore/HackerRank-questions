import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
public class TruckTourHackerRank {

    public static void main(String args[]){

        List<List<Integer>> petrolpumps = new ArrayList<List<Integer>>();

        truckTour(petrolpumps);
    }
    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        //brute force approach

        int size = petrolpumps.size();
        for(int startPump=0;startPump<size;startPump++){

            int currPumpNo = startPump;
            int pumpsVisited = 1;
            int ltRemain = 0;
            boolean canComplete = true;
            while(pumpsVisited<=size){

                int lt= petrolpumps.get(currPumpNo).get(0);
                ltRemain += lt;
                int distToTravelForNext = petrolpumps.get(currPumpNo).get(1);
                if(ltRemain < distToTravelForNext){
                    canComplete = false;
                    break;
                }


                ltRemain -= distToTravelForNext;
                currPumpNo++;
                if(currPumpNo ==size)
                    currPumpNo=0;
                pumpsVisited++;
            }

            if(canComplete==true)
                return startPump;
        }
        return -1;

    }

}
