package application;

import java.util.ArrayList;
import java.util.Random;

public class Spiel {
	private ArrayList<Spieler> spieler =new ArrayList<>();
	private boolean stand;
	Random zufallszahl = new Random();
	Spiel(){
		
		
	
		
	}

	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}

	public void setSpieler(ArrayList<Spieler> spieler) {
		this.spieler = spieler;
	}
	
		


	//Hier wird die Anzahl Spieler als Objekte angelegt
	
	public void anzahlspieler(int anzahl,int kontostand) {
		
		for(int i=0;i<anzahl;i++) {
			Spieler s =new Spieler();
			s.setSpielerid(i);
			s.setKontostand(kontostand);
			s.setName("Spieler "+i+1);
			this.spieler.add(s);
		}
	}

	//Hier werden die Karten ausgegeben für die erste runde
	
	public boolean Statuspruefung(int anzahl,int spielerid,char status) {
		stand=false;
		for(int i=spielerid ;i<anzahl;i++) {
			if(this.getSpieler().get(i).getStatus()==status)stand=true;
			
		}
		
		return stand;
		
	}
	public int zufahlzahl() {
		int n = zufallszahl.nextInt(49);
		n+=3;
		return n;
		
	}
	
	public boolean Splittprüefungspst(Deck deck,int spielerid) {
		boolean splitt=false;
		// Abfrage ob ein Splitt angezeigt werden darf
		if(deck.getDeck().get(this.getSpieler().get(spielerid).getK1()).getWert()==deck.getDeck().get(this.getSpieler().get(spielerid).getK2()).getWert()&&
			this.getSpieler().get(spielerid).getAnzahlkarten()==2&&
			this.getSpieler().get(spielerid).getSplitt()==false&&
			this.getSpieler().get(spielerid).getSetzen()<=this.getSpieler().get(spielerid).getKontostand()) splitt=true;
			
		
		return splitt;
		
	}

	public void kartengeben(Dealer dealer, Deck deck,int anzahl) {
		//Die Karten verteilung ist dem echten Spiel nachempfunden. Deshalb ist es mit 2 schleifen erstellt.
		// erste Karte
		int n ; 
		//für die Spieler
		for(int i=0;i<anzahl;i++) {
			n = zufahlzahl();
			//1Karte verteilen
			spieler.get(i).k1ziehen(n);
			//Summenrechner
			spieler.get(i).summenzähler(n, deck);
			}
		//für den Dealer
		n = zufahlzahl();
		dealer.setK1(n);
		dealer.dealersummenzähler(n,deck);
		
			
		// zweite Karte
		for(int i=0;i<anzahl;i++) {
			 n = zufahlzahl();
			 //2Karte verteilen
			spieler.get(i).k2ziehen(n);
			//Summenrechner
			spieler.get(i).summenzähler(n, deck);
			}	
		n = zufahlzahl();
		dealer.setK2(n);
		dealer.dealersummenzähler(n,deck);
		
	}

	public boolean nomoney(int anzahl) {
		
		boolean n=false,x=false;
		for(int i=0;i<anzahl;i++) {
			if(spieler.get(i).getStatus()=='n'&&x==false)n=true;
			else {x=true;
			n=false;
			}
		}
		
		return n;
	}
}
