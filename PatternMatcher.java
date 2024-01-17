import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PatternMatcher {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Scanner fileScanner;
        FileInputStream fileInStream;
        String fileName;
        String pattern;

        System.out.print("Enter a file name to search in : ");
        fileName = scnr.nextLine(); // variable file name will be stored

        try {
            fileInStream = new FileInputStream(fileName);
            fileScanner = new Scanner(fileInStream);

            System.out.println("File read successfully, initiating pattern matcher...");
            System.out.print("Enter a pattern to match (or press Enter to exit): ");
            pattern = scnr.nextLine();

        }
        catch (FileNotFoundException e){
            System.out.println("Error: File not found, exiting...");
        }
    }

    /*
     * The purpose of this public static method is to open a text file 
     * containing a list of words and return an ArrayList that contains all the words in the file. 
     * This method should be defined to throw a FileNotFoundException using the throws keyword. 
     * Later, this ArrayList will be searched to find words that match a specified pattern.
     * @param fileName - fileName from user
     * @return ArrayList which has all the words from fileName.txt file.
     */
    public static ArrayList<String> getWordList(String fileName){
        ArrayList<String> arr = new ArrayList<String>();
        return arr;
    }

    /*
     * A public static method that when called and passed a word (String), 
     * and a pattern (String), and an index (int), the method will determine 
     * if the character at the index in the pattern is a match for the character 
     * at the same index in the word. The method will return true 
     * if the characters are a match, otherwise it will return false.
     * @param word - should be checked by function
     * @param pattern - should be checked by function
     * @param index - should check word[index] == pattern[index]
     * @return if it is, true
     */
    public static boolean isMatchAtIndex(String word, String pattern, int index){

        return true;
    }

    /*
     * A public static method that when called and passed a word (String), 
     * and a pattern (String), will determine if the specified word matches the specified pattern. 
     * The method will return true if the word and pattern match,
     * otherwise it will return false.
     * @param word - word should be checked by function with pattern
     * @param pattern - function should check this pattern on the @parm word
     * @return if word includes the pattern, true
     */
    public static boolean isMatch(String word, String pattern){

        return true;
    }

    /*
     * A public static method that when called and passed a word (String), 
     * and a pattern (String), will determine if the specified word matches the specified pattern. 
     * The method will return true if the word and pattern match, otherwise it will return false.
     * @param wordList - contains the following words:
     * @param pattern - word contains this pattern or not
     * @return - if it is, true
     */
    public static ArrayList<String> getMatches(ArrayList<String> wordList, String pattern){
        ArrayList<String> arr = new ArrayList<String>();
        return arr;
    }

}
