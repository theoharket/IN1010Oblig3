import java.util.*;
//Lager en Legemiddel-klasse som lager et legemiddel-objekt som tar inn navn på legemiddelet, prisen
//, hvor mye virkestoff den inneholder og en unik ID for hvert legemiddel. Legger alle legemidler i en
//ArrayList for å kunne lage unike ID'er.
abstract class Legemiddel {
  String navn;
  double pris;
  double virkestoff;
  static ArrayList<String> legemidler = new ArrayList<>();
  int ID;

  public Legemiddel(String legemiddelNavn, double prisPaaLegemiddel, double virke ) {
    navn = legemiddelNavn;
    pris = prisPaaLegemiddel;
    virkestoff = virke;
    ID = legemidler.size();
    legemidler.add(navn);
  }
  //Returnerer ID'en til legemiddelet.
  public int  hentId() {
    return ID;
  }
  //Returnerer navnet til legemiddelet.
  public String hentNavn() {
    return navn;
  }
  //Metode som returnerer prisen på legemiddelet.
  public double hentPris() {
    return pris;
  }
  //Metode som returnerer hvor mye virkestoff det er i legemiddelet.
  public double hentVirkestoff() {
    return virkestoff;
  }

  //Metode som setter en ny pris på legemiddelet.
  public void settNyPris(String navnPaaLegemiddel, double nyPris) {
      for (int i = 0; i<legemidler.size(); i++) {
        if (navnPaaLegemiddel==legemidler.get(i)) {
          pris = nyPris;
        }
      }

  }

  public String toString() {
    return "Navn paa legemiddel: " + navn + "\nPris: " + pris + "\nVirkestoff i mg: " + virkestoff + "\nID'en til legemiddelet: " + ID + "\n";
  }
}
