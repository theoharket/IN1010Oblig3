import java.util.Scanner;
import java.io.File;


class Innleser{
    String type;
    public Innleser(String filnavn){
        Scanner fil = null;

        try{
            fil = new Scanner(new File(filnavn));

        }catch(Exception e){
            System.out.println("Feil filnavn!");
        }
        while (fil.hasNextLine()){
          String linje = fil.nextLine(); // Legger hele linjen i en variabel
          String[] testForNyType = linje.split(",");
          System.out.println(linje); // Deler linjen pa mellomrom/whitespace
          //leggTilLege(linje);
          //leggTilPasient(linje);
          leggTilResept(linje);
            }
        }

    private void leggTilResept(String linje){
        System.out.println("Legger til en Resept");

        }


    private void leggTilPasient(String linje){
        String[] pasientInfo = linje.split(",");
        String konstruktorNavn = pasientInfo[0];
        String fodselsNummer = pasientInfo[1];
        Pasient nyPasient = new Pasient(fodselsNummer,konstruktorNavn);
        }

    private void leggTilLege(String linje){

        String[] legeInfo = linje.split(",");
        int kontID = Integer.parseInt(legeInfo[1]);
        String konstruktorNavn = legeInfo[0];

        if (kontID == 0){
            Lege nyLege = new Lege(legeInfo[0]);
        }else{
            Spesialist nySpesialist = new Spesialist(legeInfo[0],kontID);
            }
        }

}

import java.util.*;

class Javameny{

    public static void main(String[] args){
    boolean harLestInnInfo = false;


    skrivMeny();


    //Scanner menyValg = new Scanner(System.in);
    //if (menyValg != instanceof Integer ){}
    //int nesteValg = menyValg.nextInt();

    int nesteValg = velgIMenyen();

    while (nesteValg != 5){
        //System.out.println("Valget var ikke 3, det var: " + nesteValg);
        if (nesteValg < 1 || nesteValg > 5){
            System.out.println("Ugyldig valg. Velge fra menyen:\n");
            //nesteValg = menyValg.nextInt();
        }else if (nesteValg == 1){
            System.out.println("\nDu har valgt å lese inn data.(alternativ 1.)\n"
            + "\nHva heter filen du vil lese inn data fra?\n");
            Scanner svar = new Scanner(System.in);
            String filNavn = svar.nextLine();
            System.out.println("\nLeser inn data fra: " + filNavn + ".");
            //Kalle på leseinn metoden jeg har laget
            System.out.println("Ferdig å lese inn");
            harLestInnInfo = true;
        } else if (nesteValg == 2){
            System.out.println("Du har valgt å se statistisk inofrmasjon om systemet\n");
            if (harLestInnInfo){
                System.out.println("Hvilken statistikk ønsker du å se?\n");
                skrivUndermeny();
            }else{
                System.out.println("Det finnes ingen info i systemet enda. Les inn en fil med menyvalg 1.\n");
            }
        } else if (nesteValg == 3){
            System.out.println("Du har valgt 3.");
        }else if (nesteValg == 4){
            System.out.println("Du har valgt 4.");
        }
        skrivMeny();
        nesteValg = velgIMenyen();
    }

    System.out.println("-----------------------");
    System.out.println("\nProgrammet avsluttes.\n");
    System.out.println("Sletter all data.\n");
    System.out.println("-----------------------");
    }


    public static void skrivMeny(){

        System.out.println("\nMenyvalgene: \n"
        +"1 - Les inn data fra fil. \n"
        +"2 - Les statistikk fra systemet.\n"
        +"3 - Ikke definert\n"
        +"4 - Ikke definert\n"
        +"5 - Avslutt\n");
    }

    public static void skrivUndermeny(){
        System.out.println("Penis");
    }

    public static int velgIMenyen(){
        Scanner menyValg = new Scanner(System.in);
        //if (menyValg != instanceof Integer ){}
        int nesteValg = menyValg.nextInt();
        return nesteValg;
    }
}
