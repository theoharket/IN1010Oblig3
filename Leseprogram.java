import java.util.Scanner;
import java.io.File;


class Filleser{
    String type;
    public Filleser(String filnavn){
        Scanner fil = null;

        try{
            fil = new Scanner(new File(filnavn));

        }catch(Exception e){
            System.out.println("Feil filnavn!");
        }
        while (fil.hasNextLine()){
          String linje = fil.nextLine(); // Legger hele linjen i en variabel
          String[] testForNyType = linje.split(""); // Deler linjen pa mellomrom/whitespace
          System.out.println(testForNyType[0]);

          if (testForNyType[0] == "#"){
            System.out.println("Her kommer en ny type");
            type = testForNyType[1];
          }

          //Alternativt folge rekkefolgen i dokumentet
          int teller = 0;
          if (testForNyType[0] == "#"){
              teller ++;
              fil.nextLine();
          }
          String[] informasjon = linje.split("");
          if (teller = 0){
              Pasient nyPasient = pasient(informasjon[1],informasjon[0]);
          }
          else if (teller = 1){
              Lege nyLege = Lege (informasjon [0], informasjon[1]);
          }
          //etc.

      }
    }
}
