package application;

public class Spieler {
	private String name;
	private int spielerid;
	private double kontostand;
	private double setzen;
	private double setzensp;
	private int k1;
	private int k2;
	private int k3;
	private int k4;
	private int k5;
	private int k6;
	private int k7;
	private int k8;
	private int k9;
	private int k10;
	private int summe;
	private int summesp;
	private int anzahlkarten;
	private int anzahlkartensp;
	private boolean ass=false;
	private boolean asssp=false;
	private boolean splitt=false;
	private char Status='r';//w=win l=loose s=stand r=run p=push n= kein Saldo mehr
	private char Statussp='r';//w=win l=loose s=stand r=run p=push
	

	Spieler(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKontostand() {
		return kontostand;
	}

	public void setKontostand(double f) {
		this.kontostand = f;
	}

	public double getSetzen() {
		return setzen;
	}

	public void setSetzen(double setzen) {
		this.setzen = setzen;
	}

	public int getK1() {
		return k1;
	}

	public void setK1(int k1) {
		this.k1 = k1;
	}

	public int getK2() {
		return k2;
	}

	public void setK2(int k2) {
		this.k2 = k2;
	}

	public int getK3() {
		return k3;
	}

	public void setK3(int k3) {
		this.k3 = k3;
	}

	public int getK4() {
		return k4;
	}

	public void setK4(int k4) {
		this.k4 = k4;
	}

	public int getK5() {
		return k5;
	}

	public void setK5(int k5) {
		this.k5 = k5;
	}

	public int getK6() {
		return k6;
	}

	public void setK6(int k6) {
		this.k6 = k6;
	}

	public int getK7() {
		return k7;
	}

	public void setK7(int k7) {
		this.k7 = k7;
	}

	public int getK8() {
		return k8;
	}

	public void setK8(int k8) {
		this.k8 = k8;
	}

	public int getK9() {
		return k9;
	}

	public void setK9(int k9) {
		this.k9 = k9;
	}

	public int getK10() {
		return k10;
	}

	public void setK10(int k10) {
		this.k10 = k10;
	}

	public int getSumme() {
		return summe;
	}

	public void setSumme(int summe) {
		this.summe = summe;
	}

	public int getSpielerid() {
		return spielerid;
	}

	public void setSpielerid(int spielerid) {
		this.spielerid = spielerid;
	}

	public int getAnzahlkarten() {
		return anzahlkarten;
	}

	public void setAnzahlkarten(int anzahlkarten) {
		this.anzahlkarten = anzahlkarten;
	}
	

	public char getStatus() {
		return Status;
	}

	public void setStatus(char status) {
		Status = status;
	}

	public boolean getAss() {
		return ass;
	}

	public void setAss(boolean ass) {
		this.ass = ass;
	}

	public boolean getSplitt() {
		return splitt;
	}

	public void setSplitt(boolean splitt) {
		this.splitt = splitt;
	}

	public int getSummesp() {
		return summesp;
	}

	public void setSummesp(int summesp) {
		this.summesp = summesp;
	}

	public double getSetzensp() {
		return setzensp;
	}

	public void setSetzensp(double setzensp) {
		this.setzensp = setzensp;
	}

	public int getAnzahlkartensp() {
		return anzahlkartensp;
	}

	public void setAnzahlkartensp(int anzahlkartensp) {
		this.anzahlkartensp = anzahlkartensp;
	}

	public boolean getAsssp() {
		return asssp;
	}

	public void setAsssp(boolean asssp) {
		this.asssp = asssp;
	}

	public char getStatussp() {
		return Statussp;
	}

	public void setStatussp(char statussp) {
		Statussp = statussp;
	}
	public void summenzähler(int n,Deck deck) {//deckwert=n 
		
		if(deck.getDeck().get(n).getWert()<14 && deck.getDeck().get(n).getWert()>10)//Auswertung ob Karte zwischen König und Bube liegt
			summe+=10;
			else if(deck.getDeck().get(n).getWert()==14)//Prüfung ob es ein ASS ist
				if(summe>10)// Prüfung ob ein 1 oder 11 + gerechnet werden muss
					summe+=1;
				else {summe+=11; 
					ass=true;}
			else summe+=deck.getDeck().get(n).getWert();// wenn nichts zu trifft wird der Kartenwert geschrieben
		if(summe>21&&ass==true) {summe-=10;
			ass=false;	}
	}
	public void summenzählersp(int n,Deck deck) {//Summenzähler bei einem Splitt für die zweite hand deckwert=n
		
		if(deck.getDeck().get(n).getWert()<14 && deck.getDeck().get(n).getWert()>10)//Auswertung ob Karte zwischen König und Bube liegt
			summesp+=10;
			else if(deck.getDeck().get(n).getWert()==14)//Prüfung ob es ein ASS ist
				if(summesp>10)// Prüfung ob ein 1 oder 11 + gerechnet werden muss
					summesp+=1;
				else {summesp+=11;
					ass=true;
				}
			else summesp+=deck.getDeck().get(n).getWert();// wenn nichts zu trift wird der Karten wert geschrieben
		if(summesp>21&&ass==true) {
			summesp-=10;
			ass=false;
			}
		}
	public void k1ziehen(int zufallszahl) {
		//Prüfung ob Saldo i.O.
		if(Status!='n') {
		summe=0;
		k1=zufallszahl;
		anzahlkarten+=1;
		}
	}
	public void k2ziehen(int zufallszahl) {
		//Prüfung ob Saldo i.O.
		if(Status!='n') {
		k2=zufallszahl;
		anzahlkarten+=1;
		}
	}
	public void snewround() {//rücksetzung für eine neue Runde
		setzen=0;
		k1=0;
		k2=0;
		k3=0;
		k4=0;
		k5=0;
		k6=0;
		k7=0;
		k8=0;
		k9=0;
		k10=0;
		summe=0;
		anzahlkarten=0;
		Status='r';
		ass=false;
		anzahlkartensp=0;
		asssp=false;
		setzensp=0;
		splitt=false;
		Statussp='r';
		summesp=0;
		setzensp=0;
		if(kontostand==0)Status='n';
	}
	public boolean auswertung() {
		boolean statusanzeigen=false;
		//Auswertung ob Blackjack
				if(summe ==21&&anzahlkarten==2) {
					Status='b';
					statusanzeigen=true;
					}
				//Auswertung ob Verloren
				else if(summe>21) {
					Status='l';
					statusanzeigen=true;}
		return statusanzeigen;// Wenn true status wird angezeigt
		
	}
	public boolean auswertungsp() {
		boolean statusanzeigensp=false;
		//Auswertung ob Blackjack
				if(summesp ==21&&anzahlkartensp==2) {
					Statussp='b';
					statusanzeigensp=true;
					}
				//Auswertung ob Verloren
				else if(summesp>21) {
					Statussp='l';
					statusanzeigensp=true;}
		return statusanzeigensp;// Wenn true status wird angezeigt
		
	}
	public void schlussauswertung(Dealer dealer) {
		//Status Prüfung auf Stand
		if(Status=='b'&& dealer.getSumme()==21&&dealer.getAnzahlkarten()==2) {
			Status='p';
			kontostand+=setzen;
		}
		if(Status=='s') {
			//Prüfung ob verloren d>s
			if(dealer.getSumme()>summe&&dealer.getSumme()<22)Status='l';
			//Prüfung ob Dealer überkauft d>21 Prüfung ob der Dealer eine kleinere Summe hat d<s
			else if (dealer.getSumme()>21||dealer.getSumme()<summe) {
				Status='w';
				kontostand+=+(setzen*2);
			}
			else if(dealer.getAnzahlkarten()==2&&dealer.getSumme()==21&&summe==21)Status='l';
			//Wenn nichts zutrifft besteht ein Push d=s
			else {Status='p';
			kontostand+=setzen;
			}
		}
		// Kontostand Berechnung bei Blackjack
	
		else if(Status=='b')kontostand+=(setzen*2.5);
			if(splitt==true) {
				//Status Prüfung auf Stand
			if(Statussp=='b'&&dealer.getSumme()==21&&dealer.getAnzahlkarten()==2) {
				Statussp='p';
				kontostand+=setzensp;
			}
			if(Statussp=='s') {
					//Prüfung ob verloren d>s
					if(dealer.getSumme()>summesp&&dealer.getSumme()<22)Statussp='l';
					//Prüfung ob Dealer überkauft d>21 Prüfung ob der Dealer eine kleinere Summe hat d<s
					else if (dealer.getSumme()>21||dealer.getSumme()<summesp) {
						Statussp='w';
						kontostand+=(setzensp*2);
					}
					else if(dealer.getAnzahlkarten()==2&&dealer.getSumme()==21&&summesp==21)Statussp='l';
					//Wenn nichts zutrifft besteht ein Push d=s
					else {Statussp='p';
					kontostand+=setzensp;
					}
				}
				// Kontostand Berechnung bei Blackjack
				else if(Statussp=='b')kontostand+=setzensp*2.5;
			}
	}

}
