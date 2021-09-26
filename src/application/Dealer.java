package application;

public class Dealer {
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
	private int anzahlkarten;
	private boolean ass;
	private boolean status; // false=karten verdeckt true =karten aufgedeckt
	
	Dealer(){
		
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

	public boolean getAss() {
		return ass;
	}

	public void setAss(boolean ass) {
		this.ass = ass;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public int getAnzahlkarten() {
		return anzahlkarten;
	}

	public void setAnzahlkarten(int anzahlkarten) {
		this.anzahlkarten = anzahlkarten;
	}

	public void dealersummenzähler(int n,Deck deck) {//n=Kartenwert
		//Abfrage ob eine Bildkarte
		if(deck.getDeck().get(n).getWert()<14 && deck.getDeck().get(n).getWert()>10)
			summe+=10;
		else if(deck.getDeck().get(n).getWert()==14)
				if(summe>10)
					summe+=1;
				else { summe+=11;
				ass=true;
				}
		else summe+=deck.getDeck().get(n).getWert();
		if(summe>21&&ass==true) {summe-=10;
			ass=false;
		}
	}
	public void dnewround() {//reset für neue runde
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
		ass=false;
		status=false;
		
	}
}
