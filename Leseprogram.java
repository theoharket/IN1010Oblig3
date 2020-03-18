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
