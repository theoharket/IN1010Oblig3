
//Definerer en Lege-klasse som tar inn navnet til legen.
import java.util.*;
class Lege {
  boolean skrevetUtNarkotisk = false;
  int antSkrevetNarkotiske =0;
  int antallNarkotiske = 0;
  int antallVanedannende = 0;
  String navn;
  int IDLege;
  static Liste<Lege> leger = new SortertLenkeliste<Lege>(); //Denne skal legges over til nettet.
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

  public void skrivUtAlleLeger() {
    int i =0;
    while(leger.neste!=NULL) {
      navn = leger.hent(i);
      System.out.println(navn);
      i++;
    }
  }

  public boolean finnesLege(String legeNavn) {
    legeNavn = legeNavn.toLowerCase();
    for (int i=0; i<leger.stoerrelse();i++) {
      if (leger.hent(i).toLowerCase()==legeNavn) {
        return true;
      }
    }
    return false;
  }

  public Lege leggTilLegeListe(Lege legen) {
    legene.leggTil(legen);
  }

  public Resept hentUtskrevedeResepter(int ID) {
    return utskrevedeResepter.hent(ID);
  }

  public Hvit skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws
UlovligUtskrift {

  if (legemiddel instanceof Vanedannende) {
    antallVanedannende++;
  } else if (legemiddel instanceof Narkotisk) {
    antallNarkotiske++;
  }
  Hvit nyResept = new Hvit(true, legemiddel,pasient, reit);
  utskrevedeResepter.leggTil(nyResept);
  return nyResept;
}

  public MilitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int
  reit) throws UlovligUtskrift {

      if (legemiddel instanceof Vanedannende) {
        antallVanedannende++;
      } else if (legemiddel instanceof Narkotisk) {
        antallNarkotiske++;
      }
      MilitaerResept nyResept = new MilitaerResept(true,legemiddel,  pasient, reit);
      //pasient.leggTilResept(nyResept);    
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {

      if (legemiddel instanceof Vanedannende) {
        antallVanedannende++;
      } else if (legemiddel instanceof Narkotisk) {
        antallNarkotiske++;
      }
      PResept nyResept = new PResept(true, legemiddel,  pasient);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws
  UlovligUtskrift  {
      if (legemiddel instanceof Vanedannende) {
        antallVanedannende++;
      } else if (legemiddel instanceof Narkotisk) {
        antallNarkotiske++;
      }
      BlaaResept nyResept = new BlaaResept(true, legemiddel, pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

}
