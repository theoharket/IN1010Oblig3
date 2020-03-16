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
  Pasient pasient;
  int reit;

  public Resept(boolean erDenGyldig, Legemiddel middel, Lege navnPaaLege, Pasient p, int antall) {
    IDantall++;
    gyldig = erDenGyldig;
    legeMiddel= middel;
    navnLege = navnPaaLege;
    pasient = p;
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
  public String hentLege() {
    return navnLege.hentNavn();
  }
  //Returnerer pasientens ID.
  public Pasient hentPasientId() {
    return pasient;
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
      gyldig = false;
      return false;
    }
  }
  //Definerer to abstrakte metoder som alle subklasser skal inneholde.
  abstract String farge();
  abstract double prisaaBetale();

}
