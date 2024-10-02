import javax.security.sasl.SaslServer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    // Method to check if a list of characters forms a palindrome
    /*
    public static boolean isPalindrome(List<Character> ls){
        // Initialize two indices: i starts at the beginning, j starts at the end
        int i, j;
        // The loop continues as long as i is less than j (i.e., until the middle of the list is reached)
        for(i = 0, j = ls.size() - 1; i < j; i++, j--){
            // Compare characters at positions i and j
            // If they are not equal, the list is not a palindrome
            if(ls.get(i) != ls.get(j)){
                return false;
            }
        }
        // If all corresponding characters match, the list is a palindrome
        return true;
    }
    */

    // Method to create a list of characters from a given string
    public static List<Character> createListString(String s){
        // Create an empty list of characters
        List<Character> characterList = new ArrayList<>();
        // Convert each character of the string into the list
        for(char c : s.toCharArray()){
            characterList.add(c);
        }
        return characterList;
    }

    // Method to create a palindrome list of a specified size n
    // If useArrayList is true, an ArrayList is used, otherwise a LinkedList is used
    public static List<Character> createPalindromeListString(int n, boolean useArrayList){
        // Define the type of list based on the useArrayList flag
        List<Character> characterList;

        if(useArrayList){
            characterList = new ArrayList<>();
        } else {
            characterList = new LinkedList<>();
        }

        // Add 'a' characters to the first half of the list
        for(int i = 0; i < n/2; i++){
            characterList.add('a');
        }

        // If n is odd, add an extra 'a' in the middle
        if(n % 2 == 1){
            characterList.add('a');
        }

        // Add 'a' characters to the second half to mirror the first half
        for(int i = n / 2 - 1; i >= 0; i--){
            characterList.add('a');
        }

        return characterList;
    }

    //Second isPalindrome
    public static  boolean isPalindrome(List<Character> ls){
        ListIterator<Character> forward = ls.listIterator();
        ListIterator<Character> backward = ls.listIterator(ls.size());

        while (forward.nextIndex() < backward.previousIndex()) {
            if (!forward.next().equals(backward.previous())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Testing the createListString and isPalindrome methods with different strings
        String test1 = "level";  // Palindrome
        String test2 = "renata"; // Not a palindrome
        String test3 = "lol";    // Palindrome
        String test4 = "insane"; // Not a palindrome

        // Create character lists from the test strings
        List<Character> list1 = createListString(test1);
        List<Character> list2 = createListString(test2);
        List<Character> list3 = createListString(test3);
        List<Character> list4 = createListString(test4);

        // Check if each list is a palindrome and print the result
        System.out.println("Test 1 'level': " + isPalindrome(list1));
        System.out.println("Test 2 'renata': " + isPalindrome(list2));
        System.out.println("Test 3 'lol': " + isPalindrome(list3));
        System.out.println("Test 4 'insane': " + isPalindrome(list4));
        System.out.println();

        // Benchmarking the performance of ArrayList vs LinkedList
        // Test the performance for palindrome lists of sizes from 10,000 to 50,000, increasing by 1,000
        /*
        int nInitial = 10000; // Starting size of the list
        int nFinal = 50000;   // Ending size of the list
        int increment = 1000; // Size increment
         */
        int nInitial = 1000000; // Starting size of the list
        int nFinal = 5000000;   // Ending size of the list
        int increment = 100000; // Size increment

        // Print the header for the performance comparison table
        System.out.println("Number  \t ArrayList Time \t LinkedList Time");

        // Loop through different sizes (n) of palindrome lists
        for(int n = nInitial; n <= nFinal; n+= increment) {
            // Create a palindrome list using an ArrayList
            List<Character> arrayList = createPalindromeListString(n, true);
            double startArrayList = System.currentTimeMillis(); // Record start time
            isPalindrome(arrayList);                            // Check if palindrome
            double endArrayList = System.currentTimeMillis();   // Record end time
            double arrayListTime = endArrayList - startArrayList; // Calculate elapsed time

            // Create a palindrome list using a LinkedList
            List<Character> linkedList = createPalindromeListString(n, false);
            double startLinkedList = System.currentTimeMillis(); // Record start time
            isPalindrome(linkedList);                            // Check if palindrome
            double endLinkedList = System.currentTimeMillis();   // Record end time
            double linkedListTime = endLinkedList - startLinkedList; // Calculate elapsed time

            // Print the size (n) and the time taken for both ArrayList and LinkedList
            System.out.println(n + "\t          " + arrayListTime + "\t              " + linkedListTime);
        }
    }
}
