class testIterabelLenkeliste{
  public static void main(String args[]){
    Liste<String> enliste = new TheodorLenkeliste<String>();

    enliste.leggTil("hei");
    enliste.leggTil("på");
    enliste.leggTil("deg");
    enliste.leggTil("din");
    enliste.leggTil("koronainfiserte");
    enliste.leggTil("leverpostei");

    for(String p : enliste){
      System.out.println(p);
    }

    System.out.println("Fjerner to elementer");
    enliste.fjern();
    enliste.fjern(3);
    System.out.println("Skriver ut igjen");
    
    for(String p : enliste){
      System.out.println(p);
    }
  }
}
