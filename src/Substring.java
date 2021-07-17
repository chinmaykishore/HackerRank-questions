/*
String s="welcometojava" has the following lexicographically-ordered substrings of length k=3 :
["ava","com","elc","eto","jav","lco","met","oja","ome","toj","wel",]

We then return the first (lexicographically smallest) substring and the last (lexicographically largest)
substring as two newline-separated values (i.e., ava\nwel).

The stub code in the editor then prints ava as our first line of output
and wel as our second line of output.

 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Substring
{

    public static void main(String[] args)
    {
        int len,k,c,i;
        //Scanner sc=new Scanner(System.in);
        String A= "welcometojava";//sc.next();
        k=3;//sc.nextInt();
        len=A.length();
        String larg=A.substring(0,k);
        String smal=A.substring(0,k);
        for(i=1;i<=len-k;i++)
        {
            String news=A.substring(i,k+i);
            c=news.compareTo(larg);
            if(c>0)
                larg=news;
            c=news.compareTo(smal);
            if(c<0)
                smal=news;
        }

        System.out.println(smal);
        System.out.println(larg);
    }
}