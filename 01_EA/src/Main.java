import javax.security.sasl.SaslServer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean isPalindrome(List<Character>ls){
        int i, j;
        for(i = 0, j = ls.size()-1; i < j; i++, j--){
            if(ls.get(i) != ls.get(j))
                return false;
        }
        return true;
    }

    public static List<Character> createListString(String s) {
        List<Character> characterList = new ArrayList<>();
        for(char c : s.toCharArray()){
            characterList.add(c);
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
    }
}