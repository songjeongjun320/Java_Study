public class Tester
{
   public static boolean isValid(int[] a, int upper)
   {
      for (int n : a) if (n < 0 || n >= upper) return false;
      for (int n : a) if (n != 0) return true;
      return false;
   }

   public static void main(String[] args)
   {
      int[] a = ArrayUtils.randomInts(4, 7);
      System.out.println("randomInts(4, 7).length: " + a.length);
      System.out.println("Expected: 4");
      System.out.println("\nAll numbers valid: " + isValid(a, 7));
      System.out.println("Expected: true");

      a = ArrayUtils.randomInts(12, 2);
      System.out.println("\nrandomInts(12, 2).length: " + a.length);
      System.out.println("Expected: 12");
      System.out.println("\nAll numbers valid: " + isValid(a, 2));
      System.out.println("Expected: true");
   }
}