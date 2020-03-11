//Definerer en klasse som implementer en lenket liste, som kan legge til objekter, endre og fjerne disse.
//Den har og en indre klasse Node, som opprettes ettersom det legges til T-objekter.

class Lenkeliste<T> implements Liste<T> {
  public int antall =0;
  public Node start = null;
//Definerer Node-klassen som holder styr på hvilket objekt som er neste, og data-objekt av typen T.
class Node {
  Node neste = null;
  T data;
    Node(T x) {
      data = x;
    }
}

    Lenkeliste() {

    }
    //Definerer en metode som returnerer antall objekter i lenkelisten.
    public int stoerrelse() {
      return antall;
    }
    //Definerer en metode som tar inn en posisjon og et T-objekt, og plasserer deretter T-objektet på ønsket posisjon.
    public void leggTil(int pos, T x) {
      if (pos<0 || pos>antall)   {
      throw new UgyldigListeIndeks(pos);
    } else {
      Node s = new Node(x);
      //Hvis ønsket posisjon er indeks 0, må vi endre start-objektet til listen.
      if (pos == 0) {
        s.neste = start;
        start = s;
        antall++;
      } else {
      Node p = start;
      Node q = null;
      for (int i = 0; i<pos;i++) {
        q = p;
        p = p.neste;
      }
      q.neste = s;
      s.neste = p;
      antall++;
    }
      }
    }
    //Definerer en metode som legger til et Node-objekt med data av type T, bakerst i lenkelisten.
    public void leggTil(T x) {
      if (antall == 0) {
        Node p = new Node(x);
        start = p;
        antall++;
      } else {
      Node p = start;
      Node q = null;
      while (p!= null) {
        q = p;
        p = p.neste;
      }
      Node s = new Node (x);
      q.neste = s;
      p = s;
      antall++;
      }
    }
    //Definerer en metode som kan endre hva som står på ønsket posisjon.
    public void sett(int pos, T x) {
      if (pos<0 || pos>=antall || antall==0)   {
      throw new UgyldigListeIndeks(pos);
    } else {
      if (pos == 0) {
        start.data = x;
      } else {
        Node p = start;
        int i = 0;
        while (i<pos) {
          i++;
          p = p.neste;
        }
        p.data = x;
      }
    }
    }
    //Definerer en metode som returnerer hva som står på ønsket posisjon
    public T hent(int pos) {
      if (pos<0 || pos>=antall || antall==0)   {
      throw new UgyldigListeIndeks(pos);
    } else {
      if (pos == 0) {
        return start.data;
      } else {
        Node p = start;
        int i = 0;

        while (i!=pos) {
          i++;
          p = p.neste;
        }
        return p.data;
        }
      }
    }


    //Definerer en metode som fjerner hva som står på ønsket posisjon og returnerer hva som ble fjernet.
    public T fjern(int pos) {
      if (pos<0 || pos>=antall || antall==0)   {
      throw new UgyldigListeIndeks(pos);
    } else {
      if (pos==0) {
        T p = start.data;
        start = start.neste;
        antall--;
        return p;
      } else {
      Node p = start;
      Node q = null;
      int i = 0;
      while (i<pos) {
        i++;
        q=p;
        p = p.neste;
      }
      if (p.neste == null) {
        if (p==null) {}
        q.neste = null;
        antall--;
        return p.data;
      }else {
      q.neste = p.neste;
      antall--;
      return p.data;
          }
        }
      }
    }

    //Definerer en metode som fjerner hva som kom inn først, og returnerer dette T-objektet.
    public T fjern() {
      if (antall==0)   {
      throw new UgyldigListeIndeks(antall);
    } else {
      T fjernet = start.data;
      start = start.neste;
      antall--;
      return fjernet;
      }
    }

}
