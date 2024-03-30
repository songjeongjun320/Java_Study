import java.util.Scanner;

/**
 * A recursive method that removes forbidden characters from a string.
 */
public class CleanUp
{
   public static String cleanHelper(String str, String forbidden, int index)
   {
      /* Your code goes here */
      String current = str.substring(index, index+1);
      System.out.println("current : " + current);
      if (forbidden.contains(current))
      {
         /* Your code goes here */
         if (str.length() - 1 == index){
            str = str.substring(0, index);  
         }
         else{
            str = str.substring(0, index) + str.substring(index + 1, str.length());
         }
         if(index == 0){
            return str;  
         }
         return cleanHelper(str, forbidden, index - 1);
      }
      else
      {
         if(index == 0){
            return str;  
         }
         /* Your code goes here */
         return cleanHelper(str, forbidden, index - 1);
      }

   }
   
   public static String clean(String str, String forbidden)
   {
      return cleanHelper(str, forbidden, str.length() - 1);
   }

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      while (in.hasNext())
      {
         String str1 = in.next();
         String str2 = in.next();
         System.out.println(clean(str1, str2));
      }
   }
}