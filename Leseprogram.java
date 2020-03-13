import java.util.Scanner;
import java.io.File;


class Filleser{
    public static void main(String[] args){

        Pasient Haakon = new Pasient("13123","Haakon");
        lesFil("Pasienter.txt");
    }

    public void lesFil(String filnavn){

        Scanner fil = null;

        try{
          fil = new Scanner(new File(filnavn));

        }catch(Exception e){
          System.out.println("Feil filnavn!");
        }
        while(fil.hasNextLine()){
            System.out.println();
            fil.nextline();
        }
    }
}
