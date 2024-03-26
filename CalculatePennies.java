import java.util.Scanner;

public class CalculatePennies {
// Returns number of pennies if pennies are doubled numDays times
   public static long doublePennies(long numPennies, int numDays) {
      long totalPennies;

      long ans = numPennies;
      for (int i = 1; i <= numDays; i++){
         ans *= 2;  
      }
      /* Your solution goes here  */
      if(numPennies == ans){
         return numPennies;  
      }

      else {
         totalPennies = doublePennies((numPennies * 2), numDays - 1);
      }

      return totalPennies;
   }

// Program computes pennies if you have 1 penny today,
// 2 pennies after one day, 4 after two days, and so on
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      long startingPennies;
      int userDays;

      startingPennies = scnr.nextLong();
      userDays = scnr.nextInt();
      System.out.println("Number of pennies after " + userDays + " days: "
           + doublePennies(startingPennies, userDays));
   }
}