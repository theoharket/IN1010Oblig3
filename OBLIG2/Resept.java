/*Definerer en Resept-klasse som inneholder ønskede inputer, og tilhørende metoder som returnerer ønskede verdier.
Tar inn om resepten er gyldig, en referanse til et legemiddel-objekt, referanse til et Lege-objekt,
Unik ID til resept, ID til pasienten som ønsker resept og reiten til Resepten.
*/
abstract class Resept {
  boolean gyldig;
  static int IDantall = 0;
  Legemiddel legeMiddel;
  int IDResept;
  Lege navnLege;
  int IDPasient;
  int reit;

  public Resept(boolean erDenGyldig,Legemiddel middel, Lege navnPaaLege, int IDP, int antall) {
    IDantall++;
    gyldig = erDenGyldig;
    legeMiddel= middel;
    navnLege = navnPaaLege;
    IDPasient = IDP;
    reit = antall;
    IDResept = IDantall;
  }
  //Returnerer ID'en til resepten.
  public int hentIdResept() {
    return IDResept;
  }
  //Returnerer referansen til objektet av klassen Legemiddel.
  public Legemiddel hentLegeMiddel() {
    return legeMiddel;
  }
  //Returnerer referansen til objektet av klassen Lege.
  public Lege hentLege() {
    return navnLege;
  }
  //Returnerer pasientens ID.
  public int hentPasientId() {
    return IDPasient;
  }
  //Returnerer reiten til resepten.
  public int hentReit() {
    return reit;
  }
  //Bruker legemiddelet en gang om det er mulig
  public boolean bruk() {
    if (reit>0) {
      reit--;
      return true;
    } else {
      return false;
    }
  }
  //Definerer to abstrakte metoder som alle subklasser skal inneholde.
  abstract String farge();
  abstract double prisaaBetale();

}
