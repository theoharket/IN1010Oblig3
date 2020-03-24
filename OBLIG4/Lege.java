
//Definerer en Lege-klasse som tar inn navnet til legen.
import java.util.*;
//import LegeListe;
class Lege {
  static Liste<Lege> LegeListe = new Stabel<Lege>();
  boolean skrevetUtNarkotisk = false;
  int antSkrevetNarkotiske =0;
  int antallNarkotiske = 0;
  int antallVanedannende = 0;
  String navn;
  int IDLege;
  static Liste<String> leger = new SortertLenkeliste<String>(); //Denne skal legges over til nettet.
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
    while(i<leger.stoerrelse()) {
      System.out.println(leger.hent(i));
      i++;
    }
  }

  public Lege _returnerLegeObjekt(String navn) {
    for (int i=0; i<leger.stoerrelse(); i++) {
      if (LegeListe.hent(i).hentNavn() == navn) {
        return LegeListe.hent(i);
      }
    }
    return LegeListe.hent(0);
  }

  public Resept hentUtskrevedeResepter(int ID) {
    return utskrevedeResepter.hent(ID);
  }

  public Hvit skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) {

  if (legemiddel instanceof Vanedannende) {
    antallVanedannende++;
  } else if (legemiddel instanceof Narkotisk) {
    antallNarkotiske++;
  }
  Lege legen = _returnerLegeObjekt(navn);
  Hvit nyResept = new Hvit(true, legemiddel,legen, pasient, reit);
  utskrevedeResepter.leggTil(nyResept);
  return nyResept;
}

  public MilitaerResept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int
  reit){

      if (legemiddel instanceof Vanedannende) {
        antallVanedannende++;
      } else if (legemiddel instanceof Narkotisk) {
        antallNarkotiske++;
      }
      Lege legen = _returnerLegeObjekt(navn);
      MilitaerResept nyResept = new MilitaerResept(true,legemiddel, legen, pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient)  {

      if (legemiddel instanceof Vanedannende) {
        antallVanedannende++;
      } else if (legemiddel instanceof Narkotisk) {
        antallNarkotiske++;
      }
      Lege legen = _returnerLegeObjekt(navn);
      PResept nyResept = new PResept(true, legemiddel, legen, pasient);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) {
      if (legemiddel instanceof Vanedannende) {
        antallVanedannende++;
      } else if (legemiddel instanceof Narkotisk) {
        antallNarkotiske++;
      }
      Lege legen = _returnerLegeObjekt(navn);
      BlaaResept nyResept = new BlaaResept(true, legemiddel, legen,  pasient, reit);
      utskrevedeResepter.leggTil(nyResept);
      return nyResept;
  }

}
