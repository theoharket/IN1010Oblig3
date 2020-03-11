class Hovedprogram {
  public static void main(String[] args) {
    //Legemiddel
    System.out.println("\nLegemidler: \n");
    Vanlig dop1 = new Vanlig("dop", 100.50,10);
    System.out.println(dop1);
    Vanedannende xanax1 = new Vanedannende("xanax", 100.50,10,100);
    System.out.println(xanax1);
    Narkotisk gront = new Narkotisk("gront", 100.2, 12, 100);
    System.out.println(gront);

    //Resepter

    System.out.println("\n\n\nResepter: \n");
    Vanlig dop2 = new Vanlig("dop", 109,10);
    Narkotisk brunt = new Narkotisk("brunt", 109, 10, 78);
    Vanedannende xanax2 = new Vanedannende("xanax", 119, 90, 100);
    Lege Johnny = new Lege("Johnny");
    BlaaResept blaaRes = new BlaaResept(true, dop2, Johnny, 10, 100);
    System.out.println(blaaRes);
    PResept pRes = new PResept(true, brunt, Johnny, 100);
    System.out.println(pRes);
    MilitaerResept milRes = new MilitaerResept(false, xanax2, Johnny, 20, 500);
    System.out.println(milRes);
    Hvit hvitRes = new Hvit(false, dop2, Johnny, 400, 1);
    System.out.println(hvitRes);
    //Sjekker om bruk-metoden fungerer
    System.out.println(hvitRes.bruk());
    System.out.println(hvitRes.bruk() + "\n");


    //Lege
    System.out.println("\n\n\nLeger: \n");
    Spesialist wang = new Spesialist("Wang", 14);
    System.out.println(wang);


  }
}
