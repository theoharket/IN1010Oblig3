import java.util.*;
import java.io.File;
class ListeOversikt{
//Her skal en liste for alle subklasser finnes.
Liste<Pasient> PasientListe = new Lenkeliste<Pasient>();
Liste<Vanlig> vanligLegemiddel = new Lenkeliste<Vanlig>();
Liste<Narkotisk> NarkotiskLegemiddel = new Lenkeliste<Narkotisk>();
Liste<Vanedannende> Vanedannende = new Lenkeliste<Vanedannende>();
Liste<Lege> LegeListe = new Lenkeliste<Lege>();
Liste<Spesialist> Spesialister = new Lenkeliste<Spesialist>();
Liste<Blaa> BlaaResepter = new Lenkeliste<Blaa>();
Liste<Hvite> HviteResepter = new Lenkeliste<Hvite>();
Liste<Presepter> PResepter = new Lenkeliste<Presepter>();
Liste<Militaerresepter> MilitaerResepter = new Lenkeliste<Militaerresepter>();

//Innlesing skal kalles på i konstruktøren.....


public void Innlesing(String filnavn){
  Scanner filleser = null;
  ArrayList <String> ferdiglestListe = new ArrayList<String>();
  try{
  filleser = new Scanner(new File(filnavn));
    }catch(Exception e){
  System.out.println("Finner ikke fil.");
}

  while(filleser.hasNextLine()){
    String enLinje = filleser.nextLine();
    ferdiglestListe.add(enLinje);
      }
    int PasientPosisjon = 0;
    int LegemidlerPosisjon = 0;
    int LegerPosisjon = 0;
    int ResepterPosisjon = 0;

    for(int i = 0; i < ferdiglestListe.size(); i++){
      if(ferdiglestListe.get(i).contains("# Pasienter")){
        PasientPosisjon = i;
      } else if(ferdiglestListe.get(i).contains("# Legemidler")){
        LegemidlerPosisjon = i;
      } else if(ferdiglestListe.get(i).contains("# Leger")){
        LegerPosisjon = i;
      } else if(ferdiglestListe.get(i).contains("# Resepter")){
        ResepterPosisjon = i;
      }
    }
    //for(int i = 0; i < ferdiglestListe.size(); i++){
    //  System.out.println(ferdiglestListe.get(i));
    //}

    for(int i = PasientPosisjon+1; i < LegemidlerPosisjon; i++){
      String linje = ferdiglestListe.get(i);
      String[] enPasient = linje.split(",");
      opprettPasient(enPasient[0], enPasient[1]);
    }


    for(int i = LegemidlerPosisjon+1; i < LegerPosisjon; i++){
      String linje = ferdiglestListe.get(i);
      String[] etLegemiddel = linje.split(",");
      if(etLegemiddel.length == 4){
        opprettVanligLegemiddel(etLegemiddel[0], etLegemiddel[2], etLegemiddel[3]);
      }else if(etLegemiddel[1].equals("narkotisk")){
        opprettNarkotiskLegemiddel(etLegemiddel[0],etLegemiddel[2],etLegemiddel[3],etLegemiddel[4]);
      } else if(etLegemiddel[1].equals("vanedannende")){
         opprettVanedannendeLegemiddel(etLegemiddel[0], etLegemiddel[2], etLegemiddel[3], etLegemiddel[4]);
        }
     }

    for(int i = LegerPosisjon+1; i < ResepterPosisjon; i++){
      String linje = ferdiglestListe.get(i);
      String[] enLege = linje.split(",");
      opprettLegeEllerSpesialist(enLege[0], enLege[1]);
      }


      //Det er en lege eller spesialist som skal skrive resept, derfor er det Theodors metoder inne i
      //Legeklassen som skal brukes til å skrive resptene. Denne metoden finner riktig lege instans og eller spesialistinstans og sender denne
      //instansen som parameter til Theodors metoder, returverdien til Theodors metoder skal så settes inn i reseptlistene.
    for(int i = ResepterPosisjon+1; i < ferdiglestListe.size(); i++){
      String linje = ferdiglestListe.get(i);
      String[] enResept = linje.split(",");

      Lege aktuelleLege = null;
      Pasient aktuellePasient = null;
      Legemiddel aktuelleLegemiddelet = null;

      int legemiddelID = Integer.parseInt(enResept[0]);
      int reit = 0;


      for(Pasient p : PasientListe){
        int ID = Integer.parseInt(enResept[2]);
        if(p.hentPasientID() == ID){
          aktuellePasient = p;
        }
      }


      //Disse forløkkene finner legen i enten spesialist eller lege liten.
      for(Lege e: LegeListe){
        if(e.hentNavn().equals(enResept[1])){
          aktuelleLege = e;
        }
      }
      for(Spesialist e: Spesialister){
        if(e.hentNavn().equals(enResept[1])){
          aktuelleLege = e;
        }
      }


      //Disse for løkkene må få det aktuelle legemiddelet til å peke mot riktig objekt i en av listene.
      for(Vanlig v : vanligLegemiddel){
        if(legemiddelID == v.hentId()){
          aktuelleLegemiddelet = v;
        }
      }
      for(Narkotisk N : NarkotiskLegemiddel){
        if(legemiddelID == N.hentId()){
          aktuelleLegemiddelet = N;
        }
      }
      for(Vanedannende V : Vanedannende){
        if(legemiddelID == V.hentId()){
          aktuelleLegemiddelet = V;
        }
      }

      //Nå har legemiddel, pasient og lege fått en verdi. Vi tar nå finner ut hvilken av Theodors metoder som skal kalles på
      //Vi må også finne ut om det er et reit eller ikke.

      if(enResept[3].equals("hvit")){
        reit = Integer.parseInt(enResept[4]);
        aktuelleLege.skrivHvitResept(aktuelleLegemiddelet, aktuellePasient, reit);
      } else if(enResept[3].equals("Blaa")){
          reit = Integer.parseInt(enResept[4]);
          aktuelleLege.skrivBlaaResept(aktuelleLegemiddelet, aktuellePasient, reit);
      } else if(enResept[3].equals("millitaer")){
          reit = Integer.parseInt(enResept[4]);
          aktuelleLege.skrivMillitaerResept(aktuelleLegemiddelet, aktuellePasient, reit);
      } else if(enResept[3].equals("p")){
        aktuelleLege.skrivPResept(aktuelleLegemiddelet, aktuellePasient);
      }
      //Disse if elif sjekkene skal sende de riktige referansene som parametere til metodene du har laget.
      //Derfra må du bruke metodene til å sette de inn i de riktige reseptlistene.
    }

  }

  private void opprettPasient(String navn, String fNr){
    Pasient nyPasient = new Pasient(navn, fNr);
    PasientListe.leggTil(nyPasient);
  }

  //LEGEMIDLER;
  //Alle metoder må typekonvertere String verdiene som egentlig skal være double, int osv..
  //Viktig at vi vet om vi skal opprette vanlig legemiddel med tre parameter, eller en av de andre med 4 parameter
    public void opprettVanligLegemiddel(String navn, String pris, String virkestoff){
      //pris og virkestoff er double.
      double Pris = Double.parseDouble(pris);
      double Virkestoff = Double.parseDouble(virkestoff);
      Vanlig nyttLegemiddel = new Vanlig(navn,Pris,Virkestoff);
      vanligLegemiddel.leggTil(nyttLegemiddel);
    }

    public void opprettNarkotiskLegemiddel(String navn, String pris, String virkestoff, String styrke){
      double Pris = Double.parseDouble(pris);
      double Virkestoff = Double.parseDouble(virkestoff);
      int Styrke = Integer.parseInt(styrke);
      NarkotiskLegemiddel.leggTil(new Narkotisk(navn, Pris, Virkestoff, Styrke));
    }

    public void opprettVanedannendeLegemiddel(String navn, String pris, String virkestoff, String styrke){
      double Pris = Double.parseDouble(pris);
      double Virkestoff = Double.parseDouble(virkestoff);
      int Styrke = Integer.parseInt(styrke);
      Vanedannende.leggTil(new Vanedannende(navn, Pris, Virkestoff, Styrke));
    }

    //LEGER
    private void opprettLegeEllerSpesialist(String navn, String kontrollid){
      int kontrollID = Integer.parseInt(kontrollid);
      if(kontrollID == 0){
        LegeListe.leggTil(new Lege(navn));
      }else{
        Spesialister.leggTil(new Spesialist(navn, kontrollID));
      }
    }

}
