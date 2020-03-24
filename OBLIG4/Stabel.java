
import java.util.ArrayList;
//Defienrer en sub-klasse av Lenkeliste, men her gjelder prinsippet som i en stabel.
//Den som kom sist, er den første til å ryke.
class Stabel<T> extends Lenkeliste<T> {

  public Stabel() {

  }
//Definerer en metode som legger til et objekt sist på stabelen
  public void leggPaa(T x) {
    if (antall>0){
    leggTil(antall, x);
  } else {
    leggTil(x);
  }
  }

//Definerer en metode som fjerner det siste elementet i stabelen, og returnerer hva den har fjernet.
  public T taAv() {
    T sisteNode = hent(antall-1);
    fjern(antall-1);
    return sisteNode;
  }
}
