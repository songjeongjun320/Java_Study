package PatternMatcher;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PatternMatcher {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String fileName;
        String pattern;
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        System.out.print("Enter a file name to search in : ");
        fileName = scnr.nextLine(); // variable file name will be stored

        try{
            arr = getWordList(fileName);
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found, exiting...");
            arr = null;
        }

        while (true){
            if (arr == null){
                break;
            }
            System.out.print("Enter a pattern to match (or press Enter to exit): ");
            pattern = scnr.nextLine();
            if (pattern == ""){
                System.out.println("Exiting...");
                break;
            }
            result = getMatches(arr, pattern);
            System.out.println(result);
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
    public static ArrayList<String> getWordList(String fileName)throws FileNotFoundException{
        ArrayList<String> arr = new ArrayList<String>();
        Scanner fileScanner;
        FileInputStream fileInStream;

        fileInStream = new FileInputStream(fileName);
        fileScanner = new Scanner(fileInStream);
        System.out.println("File read successfully, initiating pattern matcher...");
        while (fileScanner.hasNext()){
            arr.add(fileScanner.next());    
        }
        fileScanner.close();

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
        if ((word.length() < index + 1) || (pattern.length() < index + 1)){
            return false;
        }
        if ((pattern.charAt(index) == '_') || (pattern.charAt(index) == word.charAt(index))){
            return true;
        }
        return false;
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
        int size = word.length();
        if (word.length() < pattern.length()){
            size = pattern.length();
        }
        for (int i = 0 ; i < size; i++){
            if (!isMatchAtIndex(word, pattern, i)){
                return false;
            }
        }
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
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < wordList.size(); i++){
            //System.out.println(wordList.get(i));
            if (isMatch(wordList.get(i), pattern)){
                result.add(wordList.get(i));
            }
        }
        return result;
    }
}