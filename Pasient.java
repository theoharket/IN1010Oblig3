class Pasient {
	String fodselsnummer;
  	String pasientNavn;
	int pasientIDnummer;
  	static int pasientID = 0;
  	Liste<Resept> resepter = new Stabel<Resept>();


  	Pasient(String navn, String fNr) {
  		fodselsnummer = fNr;
    	pasientNavn = navn;
    	pasientIDnummer = pasientID;
    	pasientID++;
  	}

  	String hentFodselsnummer() {
  		return fodselsnummer;
  	}

  	String hentPasientNavn() {
  		return pasientNavn;
  	}

	public int hentPasientID() {
			return pasientIDnummer;
	}

	void leggTilResept(Resept r) {
		resepter.leggTil(r);
	}

	/*
	public Pasient _returnerPasientObjekt(String navn) {
	  for (int i=0; i<PasientListe.stoerrelse(); i++) {
		if (PasientListe.hent(i).hentNavn() == navn) {
		  return PasientListe.hent(i);
		}
	  }
	  return PasientListe.hent(0);
  }*/


}
