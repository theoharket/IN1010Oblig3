//Lager en subklasse av Legemiddel, Vanedannende, som legger til hvor sterk legemiddelet er.
class Vanedannende extends Legemiddel {
  int styrke;

  public Vanedannende(String legemiddelNavn, double prisPaaLegemiddel, double virke , int styrkePaaLegemiddel) {
    super(legemiddelNavn, prisPaaLegemiddel, virke);
    styrke = styrkePaaLegemiddel;
  }
  //Returnerer styrken på det vannedannende-legemiddelet.
  public int  hentVanedannendeStyrke() {
    return styrke;
  }
}
