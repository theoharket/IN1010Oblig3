
//Definerer en Lege-klasse som tar inn navnet til legen.

class Lege {

  String navn;
  int IDLege;
  static Liste<String> leger = new SortertLenkeliste<String>();
  Liste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

  public Lege(String navnetTilLegen){
    IDLege = 0;
    navn = navnetTilLegen;
    _SorterLege(navnetTilLegen);
  }

  private void _SorterLege(String navn) {
    leger.leggTil(navn);
  }
  //Returnerer navnet til legen.
  public String hentNavn() {
    return navn;
  }

  public String toString() {
    return "Navnet til legen er: " + navn;
  }

  /*public void skrivUtAlleLeger() {
    int i =0;
    while(leger.neste!=NULL) {
      navn = leger.hent(i);
      System.out.println(navn);
      i++;
    }
  }
*/
  public Resept hentUtskrevedeResepter(int ID) {
    return utskrevedeResepter.hent(ID);
  }

  public Hvit skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws
UlovligUtskrift {
  Hvit nyResept = new Hvit(true, legemiddel, Lege(navn) ,pasient, reit);
  utskrevedeResepter.leggTil(nyResept);
  return nyResept;
}

  public MilitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int
  reit) throws UlovligUtskrift {
      MilitaerResept nyResept = new MilitaerResept(true,legemiddel,  pasient, reit);
      pasient.leggTilResept(nyResept);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
      PResept nyResept = new PResept(true, legemiddel,  pasient);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws
  UlovligUtskrift  {
      BlaaResept nyResept = new BlaaResept(true, legemiddel, pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

}
