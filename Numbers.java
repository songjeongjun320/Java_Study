public class Numbers
{
   public static int zeroesDistance(double[] values)
   {
      int firstPos = 0;
      int lastPos = values.length - 1;
      boolean found = false;
      while (firstPos < values.length && !found){
         if (values[firstPos] != 0){
            firstPos = firstPos + 1;
         }
         if (values[lastPos] != 0){
            lastPos = lastPos - 1;
         }
         if((values[firstPos] == 0) && (values[lastPos] == 0)){
            found = true;  
         }
    }

      return lastPos - firstPos;
   }
}