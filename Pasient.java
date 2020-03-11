class Pasient {
	String fodselsnummer;
  	String pasientNavn;
  	static int pasientID =0;
  	Liste<Resept> resepter = new Stabel<Resept>();


  	Pasient(String fNr, String navn) {
  		fodselsnummer = fNr;
    	pasientNavn = navn;
    	pasientID;
    	pasientID++;
  	}

  	String hentFodselsnummer() {
  		return fodselsnummer;
  	}

  	String hentPasientNavn() {
  		return pasientNavn;
  	}

  	T


}
