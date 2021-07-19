/*
We're going to make our own Contacts application! The application must perform two types of operations:

1) add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
2) find partial, where partial is a string denoting a partial name to search the application for.
It must count the number of contacts starting with partial and print the count on a new line.


Given n sequential add and find operations, perform each operation in order.

Example
Operations are requested as follows:

add ed
add eddie
add edward
find ed
add edwina
find edw
find a

Three add operations include the names 'ed', 'eddie', and 'edward'. Next, find ed
matches all 3 names. Note that it matches and counts the entire name 'ed'.
Next, add 'edwina' and then find 'edw'. 2 names match: 'edward' and 'edwina'.
In the final operation, there are 0 names that start with 'a'. Return the array [3,2,0] .

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class TrieHackerRank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 7;//scan.nextInt();
        Trie trie = new Trie();
        List<String> inputlist = new ArrayList<>();
        inputlist.add("add ed");
        inputlist.add("add eddie");
        inputlist.add("add edward");
        inputlist.add("find ed");
        inputlist.add("add edwina");
        inputlist.add("find edw");
        inputlist.add("find a");

        for (int i = 0; i < n; i++) {
            String operation = inputlist.get(i).split("\\s")[0] ;//scan.next();
            String contact   = inputlist.get(i).split("\\s")[1];//scan.next();
            if (operation.equals("add")) {
                trie.add(contact);
            } else if (operation.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        scan.close();
    }
}


class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap();
    public int size = 0; // this was the main trick to decrease runtime to pass tests.

    public void putChildIfAbsent(char ch) {
        children.putIfAbsent(ch, new TrieNode());
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void add(String str) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            curr.putChildIfAbsent(ch);
            curr = curr.getChild(ch);
            curr.size++;
        }
    }

    public int find(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
}
