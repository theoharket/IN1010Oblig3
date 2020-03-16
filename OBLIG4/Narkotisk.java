//Lager en sub-klasse av Legemiddel som legger til en styrke på legemiddelet.

class Narkotisk extends Legemiddel {
  int styrke;

  public Narkotisk(String legemiddelNavn, double prisPaaLegemiddel, double virke , int styrkePaaLegemiddel) {
    super(legemiddelNavn, prisPaaLegemiddel, virke);
    styrke = styrkePaaLegemiddel;
  }
  //Returnerer styrken på legemiddelet.
  public int  hentNarkotiskStyrke() {
    return styrke;
  }
}
