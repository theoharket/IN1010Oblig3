class Hovedprogram {

  public static void main(String[] args) {
    ListeOversikt liste = new ListeOversikt();
    liste.Innlesing("eksempelfil.txt");
    Spesialist lege = liste.Spesialister.hent(0);
    lege.skrivUtAlleLeger();
    Pasient theo = liste.PasientListe.hent(1);
    System.out.println(lege.antallNarkotiske);
    System.out.println(lege.hentUtskrevedeResepter(0));
  }
}
