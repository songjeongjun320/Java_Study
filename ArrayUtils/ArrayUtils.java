public class ArrayUtils
{
   /**
    * Returns an int array of length len, with 0 >= values < n.
    * @param len the size of the returned array.
    * @param n the upper (excluded) bounds of the random numbers.
    * @return the array as described here.
    */

   public static int[] randomInts(int len, int n)
   {
      int[] result = new int[len];
      for (int i = 0; i < result.length; i++){
        int tmp = (int)(Math.random() * n);
        result[i] = tmp;
      }

      return result;
   }   
}