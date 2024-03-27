import java.util.Scanner;

public class PowerTwo
{
   public static int pow2(int n)
   {
      int ans = 1;
      if(n == 0){
         ans = 1;
      }
      else{
         ans = pow2(n-1);
         ans *= 2;
      }
      return ans;

   }
   
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      while (in.hasNextInt())
      {
         int exponent = in.nextInt();
         System.out.println(pow2(exponent));
      }      
   }
}