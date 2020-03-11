
//Definerer en Lege-klasse som tar inn navnet til legen.
class Lege {
  String navn;
  public Lege(String navnetTilLegen){
    navn = navnetTilLegen;
  }
  //Returnerer navnet til legen.
  public String hentNavnTilLege() {
    return navn;
  }

  public String toString() {
    return "Navnet til legen er: " + navn;
  }
}
