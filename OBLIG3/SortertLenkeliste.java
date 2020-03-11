//Definerer en sub-klasse av Lenkeliste som tar inn et objekt, og legger det til etter størrelse inn i
//stacken.
class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{
  SortertLenkeliste() {

  }
//Definerer en metode som tar i mot data, og legger den til i stacken etter størrelse/alfabetisk.
  public void leggTil(T x) {
  if (antall == 0) {
    super.leggTil(0,x);
    return;
  } else {
  Node p = start;
  for (int i=0; i<antall; i++) {
  if (x.compareTo(p.data)<=0) {
      super.leggTil(i,x);
      return;
    } else {
      p = p.neste;
    }
  }
  super.leggTil(x);
  return;
  }
}
//Definerer en metode som fjerner elementet som er bakerst.
  public T fjern() {
    T fjernet = fjern(antall-1);
    return fjernet;
  }
//Definerer en thrwo-metode som sier at det ikke er lov til å endre objekter som er lagt til i lenkelisten.
  public void sett(int pos, T x) {
    throw new UnsupportedOperationException();
  }
//Definerer en throw-metode som sier at det ikke er lov til å legge til objekter hvor du vil.
  public void leggTil(int pos, T x) {
    throw new UnsupportedOperationException();
  }

}
