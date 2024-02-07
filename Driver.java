class Driver {
  public static void main(String[] args) {
    int a = 98;
    int b = 0;

    for (int c = 3; c <= 6; c++) {
      b = 0;
      while (b < c) {
        b = b + 1;
        a = a - b;
      }
      b = b + a;
    }
    System.out.print(b);
  }
}