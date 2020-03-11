class TestResepter {
  public static void  main(String[] args) {
    Vanlig dop = new Vanlig("dop", 109,10);
    Narkotisk brunt = new Narkotisk("brunt", 109, 10, 78);
    Vanedannende xanax = new Vanedannende("xanax", 119, 90, 100);
    Lege Johnny = new Lege("Johnny");
    BlaaResept blaaRes = new BlaaResept(true, dop, Johnny, 10, 100);
    System.out.println(blaaRes);
    PResept pRes = new PResept(true, brunt, Johnny, 100);
    System.out.println(pRes);
    MilitaerResept milRes = new MilitaerResept(false, xanax, Johnny, 20, 500);
    System.out.println(milRes);
    Hvit hvitRes = new Hvit(false, dop, Johnny, 400, 1);
    System.out.println(hvitRes.bruk());
    System.out.println(hvitRes.bruk());
  }
}
