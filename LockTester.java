public class LockTester
{
   public static void main(String[] args)
   {
      Lock myLock = new Lock();
      
      myLock.push(1);
      myLock.push(7);
      myLock.push(3);
      myLock.push(9);
      System.out.println("Combination: 1739");
      System.out.println("Expected: false");
      System.out.println("Your output: " + myLock.open());
      System.out.println();
      
      myLock.push(1);
      myLock.push(7);
      myLock.push(2);
      myLock.push(9);
      System.out.println("Combination: 1729");
      System.out.println("Expected: true");
      System.out.println("Your output: " + myLock.open());
      System.out.println();
      
      myLock.push(1);
      myLock.push(7);
      myLock.push(2);
      System.out.println("Combination: 172");
      System.out.println("Expected: false");
      System.out.println("Your output: " + myLock.open());
      System.out.println();
      
      myLock.push(9);
      System.out.println("Combination: 9");
      System.out.println("Expected: false");
      System.out.println("Your output: " + myLock.open());
      System.out.println();
       
      myLock.push(1);
      myLock.push(7);
      myLock.push(2);
      myLock.push(9);
      System.out.println("Combination: 1729");
      System.out.println("Expected: true");
      System.out.println("Your output: " + myLock.open());
   }
}