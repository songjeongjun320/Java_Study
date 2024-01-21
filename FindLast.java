import java.util.Scanner;

public class FindLast {
   public static void main (String [] args) {
      String[] words = { "Mary", "had", "a", "little", "lamb",
                         "it's", "fleece", "was", "white", "as",
                         "snow" };
            
      Scanner in = new Scanner(System.in);
      System.out.print("Word length: ");
      int wordLength = in.nextInt();
      boolean found = false;
      int pos = -1;
      int i = 0;
      while (i < words.length)
      {
         if (words[i].length() == wordLength)
         {
            pos = i;
            found = true;
         }
         i++;
      }

      if (found == true)
      {
         System.out.println("Found " + words[pos] + " at position " + pos);
      }
      else
      {
         System.out.println("No word of length " + wordLength);
      }
   }
}