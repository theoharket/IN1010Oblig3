//Definerer en subklasse av Resept, som gjør akkurat det samme, bare at prisen er på 75% av originalpris.

class BlaaResept extends Resept {
  double pris;
  public BlaaResept(boolean erDenGyldig, Legemiddel middel, Lege navnPaaLege, int IDP, int antall) {
    super(erDenGyldig, middel, navnPaaLege, IDP, antall);
    pris = middel.hentPris()*0.25;
  }

  public String toString() {
    return "Gyldigheten: " + gyldig + "\nID'en til resepten: " + IDResept + "\nLegemiddel: " + legeMiddel.hentNavn()
    + "\nNavn paa lege: " + navnLege.hentNavnTilLege() + "\nID'en til pasienten: " + IDPasient + "\nAntall ganger igjen: "
    + reit + "\nFarge paa resept er: " + farge()+ "\nPrisen til legemiddelet er: " + prisaaBetale()+ "\n";
  }

  public String farge() {
    return "Blaa";
  }

  public double prisaaBetale() {
    return pris;
  }
}
