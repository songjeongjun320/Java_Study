import java.util.Arrays;
import java.util.Scanner;

public class FindAll
{
   /**
      Finds the positions of all occurrences of an element in an array.
      @param values an array of values
      @param searchedValue the value to search for
      @param the positions of all matches
   */
  public static int[] findAll(int[] values, int searchedValue)
  {
    int[] result = new int[values.length];
    int resultSize = 0;

    int pos = -1;
    do
    {
    pos = findNext(values, searchedValue, pos + 1);
    if (pos != -1) 
    {
        result[resultSize] = values[pos];
        resultSize++;
    }
    } while (pos < values.length);

    return result;
  }


   /**
      Finds the next occurrence of an element in an array.
      @param values an array of values
      @param searchedValue the value to search for
      @param start the position at which to start the search
      @return the position of the first match at position >= start,
      or -1 if the element was not found
   */
  public static int findNext(int[] values, int searchedValue, int start)
  {
     int result = -1;
     for (int i = start; i < values.length; i++){
          if (values[i] == searchedValue){
              result = i;  
              break;
          }
     }
     return result;
  }
   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
      String arrStr = in.nextLine();
      String[] strArray = arrStr.split(" ");
      int[] intArray = new int[strArray.length];
      for (int i = 0; i < strArray.length; i++) 
      {
         intArray[i] = Integer.parseInt(strArray[i]);
      }
      int searchedValue = in.nextInt();
      System.out.println(Arrays.toString(findAll(intArray, searchedValue)));
   }
}