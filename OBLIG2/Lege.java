
//Definerer en Lege-klasse som tar inn navnet til legen.

class Lege<T extends Comparable<Lege>> {

  String navn;
  static Liste<String> leger = new SortertLenkeliste<String>();
  Liste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

  public Lege(String navnetTilLegen){
    navn = navnetTilLegen;
    _SorterLege(navnetTilLegen);
  }

  private void _SorterLege(String navn) {
    leger.leggTil(navn);
  }
  //Returnerer navnet til legen.
  public String hentNavnTilLege() {
    return navn;
  }

  public String toString() {
    return "Navnet til legen er: " + navn;
  }

  public T hentUtskrevedeResepter(int ID) {
    System.out.println("hefi");
    return utskrevedeResepter.hent(ID);
  }

  /*
  public T hentleger() {
    return leger;
  }*/


  /*public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws
UlovligUtskrift;

  public MillitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int
  reit) throws UlovligUtskrift;

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift;

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws
  UlovligUtskrift;
*/
}
