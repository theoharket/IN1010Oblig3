class Testprogram {

public static void main(String[] args) {

  Lege theodor = new Lege("theodor");
  Vanlig vanligLegemiddel = new Vanlig("xanax", 190.5, 10);
  Pasient nyPasient = new Pasient("12345678901", "hansen");
  theodor.skrivHvitResept(vanligLegemiddel, nyPasient, 10);
  //theodor.hentUtskrevedeResepter(0);
}
}
