/*
Why there is no reverse method in String class in Java? Instead, the reverse() method is provided in StringBuilder?
Is there a reason for this? But String has split(), regionMatches(), etc., which are more complex than the reverse() method.

When they added these methods, why not add reverse()?
Ans- Since you have it in StringBuilder, there's no need for it in String, right? :-)
Seriously, when designing an API there's lots of things you could include.
The interfaces are however intentionally kept small for simplicity and clarity.
Google on "API design" and you'll find tons of pages agreeing on this.

Here's how you do it if you actually need it:
str = new StringBuilder(str1).reverse().toString();

*/
import java.io.*;
import java.util.*;

public class Reverse
{

    public static void main(String[] args)
    {


        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B= new StringBuilder(A).reverse().toString();
        int c=A.compareTo(B);
        if(c==0)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
