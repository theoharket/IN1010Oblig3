//Subklasse av Resept som lager en hvit resept, som gir en pris til personen som ønsker legemiddelet.
class Hvit extends Resept {
  double pris;
  public Hvit(boolean erDenGyldig, Legemiddel middel, Lege navnPaaLege, int IDP, int antall) {
    super(erDenGyldig, middel, navnPaaLege, IDP, antall);
    pris = middel.hentPris();
  }

  public String toString() {
    return "Gyldigheten: " + gyldig + "\nID'en til resepten: " + IDResept + "\nLegemiddel: " + legeMiddel.hentNavn()
    + "\nNavn paa lege: " + navnLege.hentNavnTilLege() + "\nID'en til pasienten: " + IDPasient + "\nAntall ganger igjen: "
    + reit + "\nFarge paa resept er: " + farge()+ "\nPrisen til legemiddelet er: " + prisaaBetale()+ "\n";
  }

  public String farge() {
    return "Hvit";
  }
  public double prisaaBetale() {
    return pris;
  }
}
