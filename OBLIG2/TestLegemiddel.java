class TestLegemiddel {
  public static void main(String[] args) {
    Vanlig dop = new Vanlig("dop", 100.50,10);
    System.out.println(dop);
    Vanedannende xanax = new Vanedannende("xanax", 100.50,10,100);
    System.out.println(xanax);
    Narkotisk theo = new Narkotisk("groent", 100.2, 12, 100);
    System.out.println(theo);

  }
}
