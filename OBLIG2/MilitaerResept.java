//Definerer en subklasse av Resept, som gjør akkurat det samme som Resept-klassen. bare at prisen for legemiddelet er 0.
class MilitaerResept extends Hvit {
  double pris;
  public MilitaerResept(boolean erDenGyldig, Legemiddel middel, Lege navnPaaLege, int IDP, int antall) {
    super(erDenGyldig, middel, navnPaaLege, IDP, antall);
    pris = 0;
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
