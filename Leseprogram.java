import java.util.Scanner;
import java.io.File;


class Filleser{
    public Filleser(String filnavn){
        Scanner fil = null;

        try{
            fil = new Scanner(new File(filnavn));

        }catch(Exception e){
            System.out.println("Feil filnavn!");
        }
        while (fil.hasNextLine()){
          String linje = fil.nextLine(); // Legger hele linjen i en variabel
          String[] informasjon = linje.split(","); // Deler linjen pa komma
          System.out.println(linje);
      }
    }
}
