import javax.security.sasl.SaslServer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static boolean isPalindrome(List<Character> ls) {
        int i, j;
        for (i = 0, j = ls.size() - 1; i < j; i++, j--) {
            if (ls.get(i) != ls.get(j))
                return false;
        }
        return true;
    }

    public static List<Character> createListString(String s) {
        List<Character> characterList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList;
    }

    public static List<Character> createPalindromeListString(int n, boolean useArrayList) {
        List<Character> characterList;

        if (useArrayList) {
            characterList = new ArrayList<>();
        } else {
            characterList = new LinkedList<>();
        }

        for (int i = 0; i < n / 2; i++) {
            characterList.add('a');
        }

        if (n % 2 == 1) {
            characterList.add('a');
        }

        for (int i = n / 2 - 1; i >= 0; i--) {
            characterList.add('a');
        }

        return characterList;
    }

    public static void main(String[] args) {
        String test1 = "level";
        String test2 = "renata";
        String test3 = "lol";
        String test4 = "insane";

        List<Character> list1 = createListString(test1);
        List<Character> list2 = createListString(test2);
        List<Character> list3 = createListString(test3);
        List<Character> list4 = createListString(test4);

        System.out.println("Test 1 'level': " + isPalindrome(list1));
        System.out.println("Test 2 'renata': " + isPalindrome(list2));
        System.out.println("Test 3 'lol': " + isPalindrome(list3));
        System.out.println("Test 4 'insane': " + isPalindrome(list4));
        System.out.println();
        //
        int nInitial = 10000;
        int nFinal = 50000;
        int increment = 1000;

        System.out.println("Number\tArrayListTime\tLinkedListTime");

        for (int n = nInitial; n <= nFinal; n += increment) {
            // ArrayList
            List<Character> arrayList = createPalindromeListString(n, true);
            long startArrayList = System.currentTimeMillis();
            isPalindrome(arrayList);
            long endArrayList = System.currentTimeMillis();
            long arrayListTime = endArrayList - startArrayList;

            // LinkedList
            List<Character> linkedList = createPalindromeListString(n, false);
            long startLinkedList = System.currentTimeMillis();
            isPalindrome(linkedList);
            long endLinkedList = System.currentTimeMillis();
            long linkedListTime = endLinkedList - startLinkedList;

            //
            System.out.println(n + "\t" + arrayListTime + "\t" + linkedListTime);
        }
    }
}
