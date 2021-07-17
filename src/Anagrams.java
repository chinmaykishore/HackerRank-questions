import java.io.*;
import java.util.*;

public class Anagrams
{

    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        char[] word1 = A.toLowerCase().replaceAll("[\\s]", "").toCharArray();
        char[] word2 = B.toLowerCase().replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        boolean ret= Arrays.equals(word1, word2);
        if(ret)
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");

    }
}
