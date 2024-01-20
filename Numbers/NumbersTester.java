public class NumbersTester
{
   public static void main(String[] args)
   {
      double[] a = { 3, 0, 1, 0, 4 };
      System.out.println(Numbers.zeroesDistance(a));
      System.out.println("Expected: 2");
      double[] b = { 0, 3, 0, 1, 0, 4 };
      System.out.println(Numbers.zeroesDistance(b));
      System.out.println("Expected: 4");
      double[] c = { 3, 0, 1, 0, 2, 3, 0, 4 };
      System.out.println(Numbers.zeroesDistance(c));
      System.out.println("Expected: 5");
      double[] d = { 0, 0, 0, 0, 0 };
      System.out.println(Numbers.zeroesDistance(d));
      System.out.println("Expected: 4");
      double[] e = { 3, 1, 4 };
      System.out.println(Numbers.zeroesDistance(e) < 0);
      System.out.println("Expected: true");
      double[] f = { };
      System.out.println(Numbers.zeroesDistance(f) < 0);
      System.out.println("Expected: true");
   }
}