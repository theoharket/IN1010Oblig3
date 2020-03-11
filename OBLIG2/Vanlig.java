//Lager en subklasse av Legemiddel, Vanlig, som har akkurat de samme egenskapene som Legemiddel.
class Vanlig extends Legemiddel {

  public Vanlig(String legemiddelNavn, double prisPaaLegemiddel, double virke) {
    super(legemiddelNavn, prisPaaLegemiddel, virke);
  }
}
