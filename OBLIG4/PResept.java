//Lager en P-Resept klasse som er en subklasse av Resept, men har kun mulighet til og brukes 3 ganger.
//Prisen blir også redusert med 108kr, men ikke billigere enn 0.
class PResept extends Hvit {
  double pris;
  public PResept(boolean erDenGyldig, Legemiddel middel, Lege navnPaaLege, Pasient p) {
    super(erDenGyldig, middel, navnPaaLege, p, 3);
    pris = settPrisPresept();



}
//Definerer en metode som lager en ny pris for legemiddelet for den spesifikke resepten. Ikke billigere enn 0.
public double settPrisPresept() {
  double pris =0;
  for (int i = 0; i<legeMiddel.legemidler.size(); i++) {
    if (i == legeMiddel.hentId()) {
      pris = legeMiddel.hentPris()-108.0;
      if (pris<0) {
        pris =0;
      }
    }
}
return pris;
}

public String PReseptText() {
  return IDResept + "," + navnLege.hentNavn() + "," + legeMiddel.hentId() + ",p,";
}

public String toString() {
  return "Gyldigheten: " + gyldig + "\nID'en til resepten: " + IDResept + "\nLegemiddel: " + legeMiddel.hentNavn()
  + "\nNavn paa lege: " + navnLege + "\nAntall ganger igjen: " + reit
  + "\nFarge paa resept er: " + farge()+ "\nPrisen til legemiddelet er: " + prisaaBetale()+ "\n";
}

public String farge() {
  return "Hvit";
}

public double prisaaBetale() {
  return pris;
}
}
