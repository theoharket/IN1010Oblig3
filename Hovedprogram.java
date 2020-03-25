import java.util.*;

class Hovedprogram{

    public static void main(String[] args){
    boolean harLestInnInfo = false;
    ListeOversikt objektOversikt = new ListeOversikt();

    skrivMeny();

    int nesteValg = velgIMenyen("Vanlig");

    while (nesteValg != 7){
        if (nesteValg < 1 || nesteValg > 7){
            ugyldigValg();
        }

        else if (nesteValg == 1){ // Alternativ for å lese inn data
            /*System.out.println("\nDu har valgt å lese inn data.\n"
            + "\nHva heter filen du vil lese inn data fra?\n");
            Scanner svar = new Scanner(System.in);
            String filNavn = svar.nextLine();
            System.out.println("\nLeser inn data og lager objekter fra: " + filNavn + "...");

            objektOversikt.Innlesing(filNavn);*/
            objektOversikt.Innlesing("Eksempelfil.txt");

            harLestInnInfo = true;
        }

        else if (nesteValg == 2){ // Alternativ for å vise statistikk
            if (harLestInnInfo){
            skrivStatistikkmeny();
            int underSvar = velgIMenyen("");
            while (underSvar != 4){

            if (underSvar < 1 || underSvar > 5){
                ugyldigValg();
                }

            else if (underSvar == 1){
                int totVaneRes = objektOversikt.Vanedannende.stoerrelse();
                System.out.println("\nDet er totalt " + totVaneRes + " utskrevne resepter med vanedannende legemidler.");
            }

            else if (underSvar == 2){
                //Må legge inn kall for å hente statistikk
                int totNarkRes = objektOversikt.NarkotiskLegemiddel.stoerrelse();
                System.out.println("\nDet er totalt " + totNarkRes + " utskrevne resepter med narkotiske legemidler.");
            }

            else if (underSvar == 3){
                System.out.println("Statistikk 3:");
                //Må legge inn kall for å hente statistikk
            }

                skrivStatistikkmeny();
                underSvar = velgIMenyen("");
            }

                System.out.println("Går tilbake til Hovedmenyen...");

        }
            else{
                    System.out.println("\nDet finnes ingen info i systemet enda. Les inn en fil med menyvalg 1.\n"
                    +"Eller legg til enkeltelementer med menyvalg 3.\n");
            }
        }

        else if (nesteValg == 3){ // Alternativ for å legge til enkeltelement
            skrivElementMeny();
            int valgIElementmeny = velgIMenyen("Element");
            System.out.println(valgIElementmeny);
            while (valgIElementmeny != 5){
                //skrivElementMeny();
                if (valgIElementmeny < 1 || valgIElementmeny > 5){
                    ugyldigValg();
                    }

                if(valgIElementmeny == 1){
                    System.out.println("valg.1, Lege");
                    harLestInnInfo = true;
                }
                else if(valgIElementmeny == 2){
                    System.out.println("valg.2, Pasient");
                    harLestInnInfo = true;
                }
                else if(valgIElementmeny == 3){
                    System.out.println("valg.3 Resept");
                    skrivReseptMeny();
                    int valgIReseptmenyen = velgIMenyen("Resept");
                    System.out.println(valgIReseptmenyen);
                    while(valgIReseptmenyen != 5){
                        if (valgIReseptmenyen < 1 || valgIReseptmenyen > 5){
                            ugyldigValg();
                            }
                            else if(valgIReseptmenyen == 1){
                                System.out.println("Lager en Blå resept");
                            }
                            else if(valgIReseptmenyen == 2){
                                System.out.println("Lager en Hvit resept");
                            }
                            else if(valgIReseptmenyen == 3){
                                System.out.println("Lager en P-Resept");
                            }
                            else if(valgIReseptmenyen == 4){
                                System.out.println("Lager en Militær resept");
                            }
                            skrivReseptMeny();
                            valgIReseptmenyen = velgIMenyen("Resept");
                            }
                            harLestInnInfo = true;
                            System.out.println("\n Returnerer til Elementmenyen.");
                        }

                else if(valgIElementmeny == 4){
                    System.out.println("valg.4 Legemiddel");
                    harLestInnInfo = true;
                }
                skrivElementMeny();
                valgIElementmeny = velgIMenyen("Element");
            }
            System.out.println("Går tilbake til hovedmenyen");
        }

        else if (nesteValg == 4){ // Alternativ for å skrive ut all info til fil
            System.out.println("\nHva ønsker du at filen skal hete? (ingen mellomrom, filen som lages blir i .txt format.):");
            Scanner menyValg = new Scanner(System.in);
            String input = menyValg.next();
            String filNavn = input+".txt";
            System.out.println(filNavn);
        }

        else if (nesteValg == 5){ // Alternativ for å bruke resept
            System.out.println("Hvilken pasient ønsker du å se resptene for:\n");
            //Legge til funksjonalitet for å bruke en resept
            Pasient valgtPerson;
            int pasientListeLengde = objektOversikt.PasientListe.stoerrelse();

            if(pasientListeLengde != 0){
                int i = 0;
                while(i < pasientListeLengde){ // Skriver ut alle pasienter
                    String pasNavn = objektOversikt.PasientListe.hent(i).hentPasientNavn();
                    String fNummer = objektOversikt.PasientListe.hent(i).hentFodselsnummer();
                    System.out.println(i
                    + " " + pasNavn
                    + " (fnr: " + fNummer + ")"
                    );
                    i++;
                }

                Scanner indeksValg = new Scanner(System.in);
                int indeksPasient = Integer.parseInt(indeksValg.next());
                if(indeksPasient >= 0 && indeksPasient < pasientListeLengde){
                    //System.out.println(indeksPasient);
                    System.out.println(objektOversikt.PasientListe.hent(indeksPasient).hentFodselsnummer());
                    Pasient pasientPeker = objektOversikt.PasientListe.hent(indeksPasient);
                    System.out.println(pasientPeker);
                    System.out.println(pasientPeker.resepter.stoerrelse());
                    System.out.println(pasientPeker.hentPasientID());



                }else{
                    System.out.println("Det finnes ingen pasient på denne indeksen.");
                }








            }else{
                System.out.println("Det funket ikke");
            }
        }

        else if (nesteValg == 6){ // Alternativ for å skrive ut alle leger

            if(harLestInnInfo){
                System.out.println("Oversikt over alle leger:\n");
                Lege.LegeListe.hent(0).skrivUtAlleLeger();
            }else{
                System.out.println("Ingen info i systemet enda.");
            }
        }

        skrivMeny(); // Skriver ut menyen på nytt etter at undervalgene er blitt kjørt ferdig.
        nesteValg = velgIMenyen("Vanlig");
    }
    avsluttUtskrift(); // Utskrift når brukeren velger å avslutte programmet
}

//Div metoder som forenkler koden over.



    private static boolean SjekkGyldigInput(String linje, String type){
        String elementType = type;
        String linjeElementer[];
        linjeElementer = new String[10];
        if (elementType == "Lege"){
            System.out.println("Lege");
        }
        else if (elementType == "Pasient"){
            System.out.println("Pasient");
        }
        else if (elementType == "Legemiddel"){
            System.out.println("Legemiddel");
        }
        else if (elementType == "Vanedannende"){
            System.out.println("Vanedannende");
        }
        else if (elementType == "Narkotisk"){
            System.out.println("Narkotisk");
        }
        else if(elementType == "Blaa"){
            System.out.println("Blaa");
        }
        else if (elementType == "Hvit"){
            System.out.println("Hvit");
        }
        else if (elementType == "P"){
            System.out.println("Presept");
        }
        else{
            System.out.println("Militær");
        }

        return true;
    }

    private static void skrivMeny(){
        System.out.println("-----------------------"
        +"\nMeny: \n"
        +"1 - Les inn data fra fil. \n"
        +"2 - Les statistikk fra systemet.\n"
        +"3 - Legg til enkeltelement\n"
        +"4 - Skriv ut alle data fra systemet til en fil\n"
        +"5 - Bruk en resept\n"
        +"6 - Skriv ut oversikt over alle leger.\n"
        +"7 - Avslutt\n"
        +"-----------------------");
    }

    private static void skrivStatistikkmeny(){
        System.out.println("\nVelg statistikk du ønsker: \n"
        +"1 - Antall resepter med vanedannende legemidler.\n"
        +"2 - Antall resepter med narkotiske legemidler.\n"
        +"3 - Statistikk om mulig misbruk av Narkotika.\n"
        +"4 - Tilbake til hovedmeny\n");
    }

    private static void skrivElementMeny(){
        System.out.println("\nHva slags element ønsker du å legge til?: \n"
        +"1 - Lege\n"
        +"2 - Pasient\n"
        +"3 - Resept\n"
        +"4 - Legemiddel\n"
        +"5 - Tilbake til hovedmeny\n");
    }

    private static void skrivReseptMeny(){
        System.out.println("\nVelg resept-type: \n"
        +"1 - Blaa\n"
        +"2 - Hvit\n"
        +"3 - P-resept\n"
        +"4 - Militær\n"
        +"5 - Tilbake til elementmeny");
    }

    private static int velgIMenyen(String kode){
        String menyKode = kode;
        int nesteValg;
        Scanner menyValg = new Scanner(System.in);
        String input = menyValg.next();
        while (isInteger(input) != true){
            System.out.println("\nDu kan bare skrive inn tall!\n"
            +"Velg på nytt.\n");
            if (menyKode == "Vanlig"){
                skrivMeny();
            }
            else if (menyKode == "Element"){
                skrivElementMeny();
            }
            else if (menyKode == "Resept"){
                skrivReseptMeny();
            }
            else{
                skrivStatistikkmeny();
            }
        menyValg = new Scanner(System.in);
        input = menyValg.next();
    }
            nesteValg = Integer.parseInt(input);
            return nesteValg;
    }

    private static void ugyldigValg(){
        System.out.println("Ugyldig valg. Velg fra menyen:\n");
    }

    private static void avsluttUtskrift(){
        System.out.println("-----------------------");
        System.out.println("\nProgrammet avsluttes.\n");
        System.out.println("Sletter all data.\n");
        System.out.println("-----------------------");
    }

    private static boolean isInteger(String input) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( Exception e ) {
        return false;
        }
    }

}
