public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("mom"));
        System.out.println(isPalindrome("jahnvi"));
    }

    public static boolean isPalindrome(String word){
        if(word.length() <= 1 ){return true;}
        
        if(word.substring(0, 1).equals(" ")){
            return isPalindrome(word.substring(1,word.length()));
        }
        if(word.substring(word.length()-1, word.length()).equals(" ")){
            return isPalindrome(word.substring(0, word.length()-1));
        }
        if(!word.substring(0,1).equals(word.substring(word.length()-1,word.length()))){
            return false;
        }
        else{
            return isPalindrome(word.substring(1, word.length() - 1));
        }
    }
}
