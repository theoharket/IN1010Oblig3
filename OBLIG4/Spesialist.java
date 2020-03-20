//Definerer en subklasse av LEge, Spesialist, som også tar inn grensesnittet Godkjenningsfritak, som bestemmer om en
//lege kan skrive ut resepter eller ikke. Denne klassen tar dermed også inn en unik kontrollID.
class Spesialist extends Lege implements Godkjenningsfritak {

    Liste<Legemiddel> narktoiskeResepter= new Lenkeliste<Legemiddel>();

  public Spesialist(String navnetTilLegen, int ID) {
    super(navnetTilLegen);
    IDLege = ID;
  }
}
  @Override

  //Metode som returnerer kontroll ID'en til spesialisten.
  public int hentKontrollID() {
    return IDLege;
  }
  public String toString() {
    return "Navnet til legen er: "+ hentNavn() + "\nKontrollID'en til spesialisten er: " + IDLege;
  }
}
