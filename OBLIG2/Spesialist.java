//Definerer en subklasse av LEge, Spesialist, som også tar inn grensesnittet Godkjenningsfritak, som bestemmer om en
//lege kan skrive ut resepter eller ikke. Denne klassen tar dermed også inn en unik kontrollID.
class Spesialist extends Lege implements Godkjenningsfritak {
  int kontrollID;

  public Spesialist(String navnetTilLegen, int ID) {
    super(navnetTilLegen);
    kontrollID = ID;
  }
  @Override

  //Metode som returnerer kontroll ID'en til spesialisten.
  public int hentKontrollID() {
    return kontrollID;
  }
  public String toString() {
    return "Navnet til legen er: "+ hentNavnTilLege() + "\nKontrollID'en til spesialisten er: " + kontrollID;
  }
}
