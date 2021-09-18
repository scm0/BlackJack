package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class MainWindowController extends Deck{
	public Main main;
	
	public Deck deck; 
	private Spiel spiel;
	public int anzahl=0,startkapital=0,spielsteuerungspieler=0,splittspieler=0;
	public int xz;
	private Dealer dealer =new Dealer();
	
	
	//Views
	@FXML private ImageView s1karte1,s1karte2,s1karte3,s1karte4,s1karte5,s1karte6,s1karte7,s1karte8,s1karte9,s1karte10;//Kartenanzeige Spieler1
	@FXML private ImageView s2karte1,s2karte2,s2karte3,s2karte4,s2karte5,s2karte6,s2karte7,s2karte8,s2karte9,s2karte10;//Kartenanzeige Spieler1
	@FXML private ImageView s3karte1,s3karte2,s3karte3,s3karte4,s3karte5,s3karte6,s3karte7,s3karte8,s3karte9,s3karte10;//Kartenanzeige Spieler1
	@FXML private ImageView s4karte1,s4karte2,s4karte3,s4karte4,s4karte5,s4karte6,s4karte7,s4karte8,s4karte9,s4karte10;//Kartenanzeige Spieler1
	@FXML private ImageView s5karte1,s5karte2,s5karte3,s5karte4,s5karte5,s5karte6,s5karte7,s5karte8,s5karte9,s5karte10;//Kartenanzeige Spieler1
	@FXML private ImageView dkarte1,dkarte2,dkarte3,dkarte4,dkarte5,dkarte6,dkarte7,dkarte8,dkarte9,dkarte10;//Kartenanzeige Dealer
	@FXML private Text dsum,s1sum,s2sum,s3sum,s4sum,s5sum,dname,s1name,s2name,s3name,s4name,s5name,s1Kontostand,s2Kontostand,s3Kontostand,s4Kontostand,s5Kontostand,s1kontostandwert,s2kontostandwert,s3kontostandwert,s4kontostandwert,s5kontostandwert;//Texte bei den Spielerfeldern
	@FXML private Text s1sumsp,s2sumsp,s3sumsp,s4sumsp,s5sumsp;
	@FXML private Text tsnpss; //Spielername bei Spielsteuerung
	@FXML private Pane pspielsteuerung,startmenu,psnamen,ps1n,ps2n,ps3n,ps4n,ps5n,ps1,ps2,ps3,ps4,ps5,pd;
	@FXML private TextField tfanzahlspieler,tfstartkapital,tfs1n,tfs2n,tfs3n,tfs4n,tfs5n;//Textfelder Startmenu
	@FXML private TextField tfsspss;// Textfel spielsteuerung
	@FXML private Button btsetzen,bnewround,bstand,bzkarte,bsplitt,bneuesspiel;
	@FXML private Label ls1status,ls2status,ls3status,ls4status,ls5status,ls1statussp,ls2statussp,ls3statussp,ls4statussp,ls5statussp;
	
	
	public MainWindowController() {
		
	deck=new Deck();
	deck.neuesdeck();
	spiel=new Spiel();
	
		
	}
	
	public void setMain(Main main) {
		
	}
	
	
	
	

	//View
	public void startmenu() {//Eingabe anzahl spieler und startkapital
			
	try {	//Prüfung ob die Anzahl zwischen 1-5 liegt
	String t=tfanzahlspieler.getText();
	if(Integer.parseInt(t)>5||Integer.parseInt(t)<1)tfanzahlspieler.setText("Geben Sie eine Zahl von 1-5 ein.");
		else if(tfanzahlspieler.getText()==null)tfanzahlspieler.setText("Geben Sie eine Zahl von 1-5 ein.");
	else {anzahl =Integer.parseInt(t);System.out.println(anzahl+"anzahl");
		}
	} catch (Exception e) {
		// TODO Automatisch generierter Erfassungsblock
		e.printStackTrace();
		tfanzahlspieler.setText("Falsche Eingabe");}
	
	//Prüfung ob das Startkapital zwischen 1und 10000 liegt
	try {String z=tfstartkapital.getText();	
		if(Integer.parseInt(z)<1||Integer.parseInt(z)>10000)tfstartkapital.setText("Geben Sie einen Wert zwischen 1 und 10'000 ein");
		else startkapital =Integer.parseInt(z);
		
		
		} catch (Exception e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			tfstartkapital.setText("Falsche Eingabe");
			}
	// Die Eingabe für die Namen der Spieler Sichtbar setzen
		if(anzahl!=0&&startkapital!=0) {
				psnamen.setVisible(true);
		switch(anzahl) {
		case 1: ps1n.setVisible(true);
				ps2n.setVisible(false);
				ps3n.setVisible(false);
				ps4n.setVisible(false);
				ps5n.setVisible(false);break;
		case 2:	ps1n.setVisible(true);
				ps2n.setVisible(true);
				ps3n.setVisible(false);
				ps4n.setVisible(false);
				ps5n.setVisible(false);break;
		case 3:	ps1n.setVisible(true);
				ps2n.setVisible(true);
				ps3n.setVisible(true);
				ps4n.setVisible(false);
				ps5n.setVisible(false);break;
		case 4:	ps1n.setVisible(true);
				ps2n.setVisible(true);
				ps3n.setVisible(true);
				ps4n.setVisible(true);
				ps5n.setVisible(false);break;
		case 5:	ps1n.setVisible(true);
				ps2n.setVisible(true);
				ps3n.setVisible(true);
				ps4n.setVisible(true);
				ps5n.setVisible(true);break;
		}
		//Panel sichtbar setzen
		pd.setVisible(true);
	}
	}
	public void spielsteuerung() {//Hier werden die Eingaben währen des Spiels getätigt
		//Abfrage ob ein Splitt möglich ist
		if(spiel.Splittprüefungspst(deck, spielsteuerungspieler)==true)bsplitt.setVisible(true);
				
		//Bleibt solange beim gleichen Spieler bis dieser ein anderen status hat
		if(spiel.getSpieler().get(spielsteuerungspieler).getStatus()=='r'||spiel.getSpieler().get(spielsteuerungspieler).getStatussp()=='r'&&spiel.getSpieler().get(spielsteuerungspieler).getSplitt()==true) {
			pspielsteuerung.setVisible(true);
			tsnpss.setText(spiel.getSpieler().get(spielsteuerungspieler).getName());
		}
		//Abfrage ob ein Spieler noch am spielen ist
			else if(spiel.Statuspruefung(anzahl,0, 'r')==true) {	pspielsteuerung.setVisible(false);
					spielsteuerungspieler+=1;
					bsplitt.setVisible(false);
					spielsteuerung();
					}
		//Wenn jeder seine Karten hat geht es zum Dealer
			else if (dealer.getStatus()==false) {int i=0;i++;
				zdealerkartenanzeigen();System.out.println(i+"counter");
				bsplitt.setVisible(false);}
						
	}
	
	
	//Buttons
	@FXML
	public void start() {//spielstarten
		//spieler erstellen
		System.out.println(anzahl+"anzahl");
		spiel.anzahlspieler(anzahl,startkapital);
		//Namen der Spieler einlesen 
		try {
			for(int i=0;i<anzahl;i++) {
				spielerpanel(true,i);System.out.println(i+"start");
				switch(i) {
					case 0: spiel.getSpieler().get(i).setName(tfs1n.getText());
							s1name.setText(spiel.getSpieler().get(i).getName());
							s1kontostandwert.setText(Double.toString(spiel.getSpieler().get(i).getKontostand()));
							break;
					case 1: spiel.getSpieler().get(i).setName(tfs2n.getText());
							s2name.setText(spiel.getSpieler().get(i).getName());
							s2kontostandwert.setText(Double.toString(spiel.getSpieler().get(i).getKontostand()));
							spielerpanel(true,i);
							break;
					case 2: spiel.getSpieler().get(i).setName(tfs3n.getText());
							s3name.setText(spiel.getSpieler().get(i).getName());
							s3kontostandwert.setText(Double.toString(spiel.getSpieler().get(i).getKontostand()));
							break;
					case 3: spiel.getSpieler().get(i).setName(tfs4n.getText());
							s4name.setText(spiel.getSpieler().get(i).getName());
							s4kontostandwert.setText(Double.toString(spiel.getSpieler().get(i).getKontostand()));
							break;
					case 4:	spiel.getSpieler().get(i).setName(tfs5n.getText());
							s5name.setText(spiel.getSpieler().get(i).getName());
							s5kontostandwert.setText(Double.toString(spiel.getSpieler().get(i).getKontostand()));
							break;
					}
				}
				
			} catch (Exception e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			tfs1n.setText("nicht alle Eingaben korrekt");
			}
		
		if(tfs1n.getText()!="nicht alle Eingaben korrekt") {
			tfsspss.setVisible(true);
			btsetzen.setVisible(true);
			startmenu.setVisible(false);
			spielsteuerung();//öffnen der spielsteuerung mit dem ersten Spieler
				
		}
				
		
	}
	@FXML
	public void zkarte() {//+1 Karte Button
		
		//Splitt Button unsichtbar setzen
		bsplitt.setVisible(false);
		
		
		
		// Vergabe der zufallszahl je nach anzahl karten
		if(spiel.getSpieler().get(spielsteuerungspieler).getStatus()=='r') {
			int n = spiel.zufahlzahl();
			spiel.getSpieler().get(spielsteuerungspieler).setAnzahlkarten(spiel.getSpieler().get(spielsteuerungspieler).getAnzahlkarten()+1);
			switch(spiel.getSpieler().get(spielsteuerungspieler).getAnzahlkarten()) {
			case 3:spiel.getSpieler().get(spielsteuerungspieler).setK3(n); break;
			case 4:spiel.getSpieler().get(spielsteuerungspieler).setK4(n); break;
			case 5:spiel.getSpieler().get(spielsteuerungspieler).setK5(n); break;
			case 6:spiel.getSpieler().get(spielsteuerungspieler).setK6(n); break;
			case 7:spiel.getSpieler().get(spielsteuerungspieler).setK7(n); break;
			case 8:spiel.getSpieler().get(spielsteuerungspieler).setK8(n); break;
			case 9:spiel.getSpieler().get(spielsteuerungspieler).setK9(n); break;
			case 10:spiel.getSpieler().get(spielsteuerungspieler).setK10(n); break;
				}
			
			//summe berechnen
			spiel.getSpieler().get(spielsteuerungspieler).summenzähler(n, deck);
			//zwischen stands abfrage ob verloren
			if(spiel.getSpieler().get(spielsteuerungspieler).auswertung()==true)statusanzeige(spielsteuerungspieler);
			zkartenanzeigen(spielsteuerungspieler);
			spielsteuerung();
			}
		
		//Abfrage des Status von der 1 Hand ob diese zuende gespielt ist,wenn ja wird die zweite hand gespielt
		else if(spiel.getSpieler().get(spielsteuerungspieler).getSplitt()==true) {
			// Zufallszahlgenerieren
			int n = spiel.zufahlzahl();
			if(spiel.getSpieler().get(spielsteuerungspieler).getAnzahlkartensp()==2) spiel.getSpieler().get(spielsteuerungspieler).setAnzahlkarten(7);
			spiel.getSpieler().get(spielsteuerungspieler).setAnzahlkarten(spiel.getSpieler().get(spielsteuerungspieler).getAnzahlkarten()+1);
			spiel.getSpieler().get(spielsteuerungspieler).setAnzahlkartensp(+1);
			switch(spiel.getSpieler().get(spielsteuerungspieler).getAnzahlkarten()) {
			
			case 8:spiel.getSpieler().get(spielsteuerungspieler).setK8(n); break;
			case 9:spiel.getSpieler().get(spielsteuerungspieler).setK9(n); break;
			case 10:spiel.getSpieler().get(spielsteuerungspieler).setK10(n); break;
			}
			
			//Summe berechnen
			spiel.getSpieler().get(spielsteuerungspieler).summenzählersp(n,deck);
			////zwischen stands abfrage ob verloren
			if(spiel.getSpieler().get(spielsteuerungspieler).auswertungsp()==true)statusanzeigesp(spielsteuerungspieler);
			zkartenanzeigen(spielsteuerungspieler);
			spielsteuerung();
			
		}	
	
	}
	@FXML
	public void setzen() {//Betrag setzen
		//Prüfung ob ein Spieler pleite ist
		if(spiel.getSpieler().get(spielsteuerungspieler).getStatus()=='n') spielsteuerungspieler+=1;
		else {	
			//Eingabe des gewünschten Betrags
			try {if(Integer.parseInt(tfsspss.getText())<=spiel.getSpieler().get(spielsteuerungspieler).getKontostand()&&Integer.parseInt(tfsspss.getText())>0) {
					spiel.getSpieler().get(spielsteuerungspieler).setSetzen(Integer.parseInt(tfsspss.getText()));
					spiel.getSpieler().get(spielsteuerungspieler).setKontostand(spiel.getSpieler().get(spielsteuerungspieler).getKontostand()-spiel.getSpieler().get(spielsteuerungspieler).getSetzen());
					kontostandanzeigen(spielsteuerungspieler);
					spielsteuerungspieler+=1;
					}
				else tfsspss.setText("Kontostand zu klein");
				}	
			catch (Exception e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			tfsspss.setText("Eingabe nicht korrekt");
			}
		}
		//Prüfung ob alle gesetzt haben	die Berechtigt sind
		if(spiel.Statuspruefung(anzahl,spielsteuerungspieler, 'r')==true)spielsteuerung();		
		//Wechsel zu Spielbetrieb
		else  {	//Spielsteuerung anpassen
				pspielsteuerung.setVisible(false);
				tfsspss.setVisible(false);
				btsetzen.setVisible(false);
				//Sequenzer auf 0 setzen
				spielsteuerungspieler=0;
				bzkarte.setVisible(true);
				bstand.setVisible(true);
				spiel.kartengeben(dealer,deck,anzahl);
				for(int i=0;i<anzahl;i++) {
				kartenanzeigen(i);}
				spielsteuerung();
		
		
		}
		
	}	
	@FXML
	public void stand() {//Keine Karte mehr
		//Button unsichtbar setzen
		bsplitt.setVisible(false);
		//Abfrage um welche Hand es sich handelt (Splitt)
		if(spiel.getSpieler().get(spielsteuerungspieler).getStatus()!='r'&&spiel.getSpieler().get(spielsteuerungspieler).getSplitt()==true)spiel.getSpieler().get(spielsteuerungspieler).setStatussp('s');
		else spiel.getSpieler().get(spielsteuerungspieler).setStatus('s');
		//öffnen der Spielsteuerung
		spielsteuerung();
	
	}
	public void splitt() {//Ausgabe bei Splitt
	spiel.getSpieler().get(spielsteuerungspieler).setSplitt(true);//Wert setzen bei Spieler um zu merken das ein Splitt gespielt wird
	splittspieler=spiel.getSpieler().get(spielsteuerungspieler).getSpielerid();
	//Wert K2 von Summe abziehen
	int n=spiel.getSpieler().get(spielsteuerungspieler).getK2();
	if(deck.getDeck().get(n).getWert()<14 && deck.getDeck().get(n).getWert()>10)//Auswertung ob Karte zwischen König und Bube liegt
		spiel.getSpieler().get(spielsteuerungspieler).setSumme(spiel.getSpieler().get(spielsteuerungspieler).getSumme()-10);
	else if(deck.getDeck().get(n).getWert()==14)
		if(spiel.getSpieler().get(spielsteuerungspieler).getSumme()>10)// Prüfung ob ein 1 oder 11 + gerechnet werden muss
			spiel.getSpieler().get(spielsteuerungspieler).setSumme(spiel.getSpieler().get(spielsteuerungspieler).getSumme()-1);
		else {spiel.getSpieler().get(spielsteuerungspieler).setSumme(spiel.getSpieler().get(spielsteuerungspieler).getSumme()-11);
			spiel.getSpieler().get(spielsteuerungspieler).setAss(false);
		}
	else spiel.getSpieler().get(spielsteuerungspieler).setSumme(spiel.getSpieler().get(spielsteuerungspieler).getSumme()-deck.getDeck().get(n).getWert());// wenn nichts zu trift wird der Karten wert geschrieben
	
	//gesetzter betrag auf zweite hand übertragen
	spiel.getSpieler().get(spielsteuerungspieler).setSetzensp(spiel.getSpieler().get(spielsteuerungspieler).getSetzen());
	spiel.getSpieler().get(spielsteuerungspieler).setKontostand(spiel.getSpieler().get(spielsteuerungspieler).getKontostand()-spiel.getSpieler().get(spielsteuerungspieler).getSetzensp());
	kontostandanzeigen(spielsteuerungspieler);
	// neue verteilung der Karten
	spiel.getSpieler().get(spielsteuerungspieler).setK6(spiel.getSpieler().get(spielsteuerungspieler).getK2());
	spiel.getSpieler().get(spielsteuerungspieler).summenzählersp(spiel.getSpieler().get(spielsteuerungspieler).getK2(), deck);
	n =  spiel.zufahlzahl();
	spiel.getSpieler().get(spielsteuerungspieler).summenzähler(n, deck);
	spiel.getSpieler().get(spielsteuerungspieler).setK2(n);
	n=spiel.zufahlzahl();
	spiel.getSpieler().get(spielsteuerungspieler).summenzählersp(n,deck);
	spiel.getSpieler().get(spielsteuerungspieler).setK7(n);
	
	//Anzahlkarten für Splitt setzen
	spiel.getSpieler().get(spielsteuerungspieler).setAnzahlkartensp(2);
	//Anzeige der Karten im GUI
	kartenanzeigen(spielsteuerungspieler);
	
	//Taster unsichtbar setzen
	bsplitt.setVisible(false);
	
	}
	public void newround() {//Neue Runde
		
		spielsteuerungspieler=0;// rücksetzen für neue runde 
		//Spieler rücksetzen
		for(int i=0;i<anzahl;i++) {
			spiel.getSpieler().get(i).snewround();
		}
		//view rücksetzen
		resetview();
		//dealer rücksetzen
		dealer.dnewround();
		
		//View für neue Runde anzeigen lassen
		bnewround.setVisible(false);
		bneuesspiel.setVisible(false);
		tfsspss.setVisible(true);
		btsetzen.setVisible(true);
		bstand.setVisible(false);
		bzkarte.setVisible(false);
		spielsteuerung();
	
	}
	public void neuesspiel() {//Neues Spiel
		//Spieler löschen
		for(int i=anzahl-1;i>=0;i--){
		spiel.getSpieler().remove(i);}
		//Spieler Anzeigen unsichtbar setzen
		for(int i=0;i<anzahl;i++) {
			spielerpanel(false,i);
		}
		// Anzeige starten für neues Spiel
		spielsteuerungspieler=0;
		resetview();
		dealer.dnewround();
		psnamen.setVisible(false);
		bnewround.setVisible(false);
		bneuesspiel.setVisible(false);
		pspielsteuerung.setVisible(false);
		startmenu.setVisible(true);
	}
	
	//Anzeigen
	public void zkartenanzeigen(int spielerid) {//+1 Karte Anzeigen
		
		// Anzeige der zusätzlichenkarten switch1 welcher spieler switch2 welche Karte
		
				switch(spiel.getSpieler().get(spielerid).getSpielerid()) {
				case 0: s1sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
						if(spiel.getSpieler().get(spielerid).getSplitt()==true)s1sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						switch(spiel.getSpieler().get(spielerid).getAnzahlkarten()) {
						case 3:s1karte3.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK3()).getImage());break;
						case 4:s1karte4.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK4()).getImage());break;
						case 5:s1karte5.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK5()).getImage());break;
						case 6:s1karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());break;
						case 7:s1karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());break;
						case 8:s1karte8.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK8()).getImage());break;
						case 9:s1karte9.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK9()).getImage());break;
						case 10:s1karte10.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK10()).getImage());break;
						}break;
				case 1: s2sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
						if(spiel.getSpieler().get(spielerid).getSplitt()==true)s2sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						switch(spiel.getSpieler().get(spielerid).getAnzahlkarten()) {
						case 3:s2karte3.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK3()).getImage());break;
						case 4:s2karte4.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK4()).getImage());break;
						case 5:s2karte5.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK5()).getImage());break;
						case 6:s2karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());break;
						case 7:s2karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());break;
						case 8:s2karte8.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK8()).getImage());break;
						case 9:s2karte9.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK9()).getImage());break;
						case 10:s2karte10.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK10()).getImage());break;
						}break;
				case 2: s3sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
						if(spiel.getSpieler().get(spielerid).getSplitt()==true)s3sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						switch(spiel.getSpieler().get(spielerid).getAnzahlkarten()) {
						case 3:s3karte3.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK3()).getImage());break;
						case 4:s3karte4.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK4()).getImage());break;
						case 5:s3karte5.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK5()).getImage());break;
						case 6:s3karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());break;
						case 7:s3karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());break;
						case 8:s3karte8.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK8()).getImage());break;
						case 9:s3karte9.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK9()).getImage());break;
						case 10:s3karte10.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK10()).getImage());break;
						}break;
				case 3: s4sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
						if(spiel.getSpieler().get(spielerid).getSplitt()==true)s4sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						switch(spiel.getSpieler().get(spielerid).getAnzahlkarten()) {
						case 3:s4karte3.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK3()).getImage());break;
						case 4:s4karte4.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK4()).getImage());break;
						case 5:s4karte5.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK5()).getImage());break;
						case 6:s4karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());break;
						case 7:s4karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());break;
						case 8:s4karte8.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK8()).getImage());break;
						case 9:s4karte9.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK9()).getImage());break;
						case 10:s4karte10.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK10()).getImage());break;
						}break;
				case 4: s5sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
						if(spiel.getSpieler().get(spielerid).getSplitt()==true)s5sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						switch(spiel.getSpieler().get(spielerid).getAnzahlkarten()) {
						case 3:s5karte3.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK3()).getImage());break;
						case 4:s5karte4.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK4()).getImage());break;
						case 5:s5karte5.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK5()).getImage());break;
						case 6:s5karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());break;
						case 7:s5karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());break;
						case 8:s5karte8.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK8()).getImage());break;
						case 9:s5karte9.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK9()).getImage());break;
						case 10:s5karte10.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK10()).getImage());break;
						}break;
						
					}
				
				}
	public void kartenanzeigen(int spielerid) {	//Die ersten 2 Karten Anzeigen lassen	
		//Abfrage ob Spieler noch Geld hat
		if(spiel.getSpieler().get(spielerid).getStatus()!='n') {
		////zwischen stands abfrage ob Blackjack
			if(spiel.getSpieler().get(spielerid).auswertung()==true)statusanzeige(spielerid);
			if(spiel.getSpieler().get(spielerid).auswertungsp()==true)statusanzeigesp(spielerid);
			switch(spielerid) {//if Abfrage greift bei einem Splitt
		
			case 0:	s1karte1.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK1()).getImage());
					s1karte2.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK2()).getImage());
					s1sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
					s1sum.setVisible(true);
					if(spiel.getSpieler().get(spielerid).getSplitt()==true) {
						s1karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());
						s1karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());
						s1sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						s1sumsp.setVisible(true);}
					break;
			case 1: s2karte1.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK1()).getImage());
					s2karte2.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK2()).getImage());
					s2sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
					s2sum.setVisible(true);
					if(spiel.getSpieler().get(spielerid).getSplitt()==true) {
						s2karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());
						s2karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());
						s2sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						s2sumsp.setVisible(true);}
					break;
			case 2:	s3karte1.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK1()).getImage());
					s3karte2.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK2()).getImage());
					s3sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
					s3sum.setVisible(true);
					if(spiel.getSpieler().get(spielerid).getSplitt()==true) {
						s3karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());
						s3karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());
						s3sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						s3sumsp.setVisible(true);}
					break;
			case 3: s4karte1.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK1()).getImage());
					s4karte2.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK2()).getImage());
					s4sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
					s4sum.setVisible(true);
					if(spiel.getSpieler().get(spielerid).getSplitt()==true) {
						s4karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());
						s4karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());
						s4sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						s4sumsp.setVisible(true);}
					break;
			case 4: s5karte1.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK1()).getImage());
					s5karte2.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK2()).getImage());
					s5sum.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSumme()));
					s5sum.setVisible(true);
					if(spiel.getSpieler().get(spielerid).getSplitt()==true) {
						s5karte6.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK6()).getImage());
						s5karte7.setImage(deck.getDeck().get(spiel.getSpieler().get(spielerid).getK7()).getImage());
						s5sumsp.setText(Integer.toString(spiel.getSpieler().get(spielerid).getSummesp()));
						s5sumsp.setVisible(true);}
					break;
			
				
			}
			
			
		}
		
	dealerkartenanzeigen();	
	}
	public void dealerkartenanzeigen() {//Karten des dealers Anzeigen
		try {
		dkarte1.setImage(deck.getDeck().get(dealer.getK1()).getImage());
		dkarte2.setImage(deck.getDeck().get(52).getImage());
		dsum.setText(Integer.toString(dealer.getSumme()));
		dsum.setVisible(true);
		}catch (Exception e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			System.out.println("nix gehen");;
		}
		;
	}
	public void zdealerkartenanzeigen() {//+ Karten für Dealer
		dealer.setStatus(true);
		//Zufallszahl für 2 Karte
		int n = spiel.zufahlzahl();
		dkarte2.setImage(deck.getDeck().get(dealer.getK2()).getImage());
		dealer.setAnzahlkarten(2);
		//Anzahlkarten für die Anzeige
		int i=3;
		//Kartenaufnahme bis Summe grösser wie 17, wenn kein status stand ist wird keine zusätzliche Karte benötigt.
		while(dealer.getSumme()<17&&spiel.Statuspruefung(anzahl,0, 's')){
			//Zufällige Zahl für zusatzKarte
			n = spiel.zufahlzahl();
			//Aufruf des Summenzählers
			dealer.dealersummenzähler(n,deck);
			//Anzeige der Summe dies dient zum Testen und ist bei normaler Anwendung nicht sichtbar
			dsum.setText(Integer.toString(dealer.getSumme()));
			//Anzeige der Karten
		switch(i) {
			case 3:	dealer.setK3(n);
					dkarte3.setImage(deck.getDeck().get(dealer.getK3()).getImage());
					break;
			case 4:	dealer.setK4(n);
					dkarte4.setImage(deck.getDeck().get(dealer.getK4()).getImage());
					break;
			case 5: dealer.setK5(n);
					dkarte5.setImage(deck.getDeck().get(dealer.getK5()).getImage());
					break;
			case 6:	dealer.setK6(n);
					dkarte6.setImage(deck.getDeck().get(dealer.getK6()).getImage());
					break;
			case 7:	dealer.setK7(n);
					dkarte7.setImage(deck.getDeck().get(dealer.getK7()).getImage());
					break;
			case 8: dealer.setK8(n);
					dkarte8.setImage(deck.getDeck().get(dealer.getK8()).getImage());
					break;
			case 9:	dealer.setK7(n);
					dkarte9.setImage(deck.getDeck().get(dealer.getK9()).getImage());
					break;
			case 10: dealer.setK8(n);
					dkarte10.setImage(deck.getDeck().get(dealer.getK10()).getImage());
					break;
			
		}
		i++;
		dealer.setAnzahlkarten(i);
		}
		for(int x=0;x<anzahl;x++) {
		//Die entscheidende auswertung wer gewonnen hat
		spiel.getSpieler().get(x).schlussauswertung(dealer);
		spiel.getSpieler().get(x).schlussauswertungsp(dealer);
		kontostandanzeigen(x);
		statusanzeigesp(x);
		statusanzeige(x);
		if(spiel.getSpieler().get(x).getKontostand()==0)spiel.getSpieler().get(x).setStatus('n');
		}
		//Vorbereitung nächste runde
		bzkarte.setVisible(false);
		bstand.setVisible(false);
		bneuesspiel.setVisible(true);
		tsnpss.setText("Noch ein Spiel?");
		if(spiel.nomoney(anzahl)==false) {	bnewround.setVisible(true);
			tsnpss.setText("Noch eine Runde?");}
			
		pspielsteuerung.setVisible(true);
		spielsteuerung();
	}
	public void kontostandanzeigen(int i) {//Kontostandsanzeige
		//i=spielerid
		switch(i) {
		
		case 0: s1kontostandwert.setText(String.valueOf(spiel.getSpieler().get(i).getKontostand()));break;
		case 1: s2kontostandwert.setText(String.valueOf(spiel.getSpieler().get(i).getKontostand()));break;
		case 2: s3kontostandwert.setText(String.valueOf(spiel.getSpieler().get(i).getKontostand()));break;
		case 3: s4kontostandwert.setText(String.valueOf(spiel.getSpieler().get(i).getKontostand()));break;
		case 4: s5kontostandwert.setText(String.valueOf(spiel.getSpieler().get(i).getKontostand()));break;
		
		}
	}
	public void statusanzeige(int i) {//Status Anzeige
		//i=spielerid
		//Wert für die anzeige
		String status="r";
		//Auswertung welcher Text angezeigt werden muss
		if(spiel.getSpieler().get(i).getStatus()=='b') status= "BlackJack";
		else if(spiel.getSpieler().get(i).getStatus()=='w')status="Win";
		else if (spiel.getSpieler().get(i).getStatus()=='l')status="Loose";
		else if(spiel.getSpieler().get(i).getStatus()=='p')status="Push";
		else if(spiel.getSpieler().get(i).getStatus()=='n')status="NoMoney";
		
		//Label wird beschrieben
		if(status!="r") {
		switch(i) {
		case 0:	ls1status.setText(status);
				ls1status.setVisible(true);break;
		case 1:	ls2status.setText(status);
				ls2status.setVisible(true);break;
		case 2:	ls3status.setText(status);
				ls3status.setVisible(true);break;
		case 3:	ls4status.setText(status);
				ls4status.setVisible(true);break;
		case 4:	ls5status.setText(status);
				ls5status.setVisible(true);break;
				
			}
		}
	}
	public void statusanzeigesp(int i) {//Status Anzeige für Splitt
		//i=spielerid
		//Wert für die anzeige
		String status="r";
		//Auswertung welcher Text angezeigt werden muss		
		if(spiel.getSpieler().get(i).getStatussp()=='b') status= "BlackJack";
		else if(spiel.getSpieler().get(i).getStatussp()=='w')status="Win";
		else if (spiel.getSpieler().get(i).getStatussp()=='l')status="Loose";
		else if(spiel.getSpieler().get(i).getStatussp()=='p')status="Push";
		//Label wird beschrieben
		if(status!="r") {
		switch(i) {
		case 0:	ls1statussp.setText(status);
				ls1statussp.setVisible(true);break;
		case 1:	ls2statussp.setText(status);
				ls2statussp.setVisible(true);break;
		case 2:	ls3statussp.setText(status);
				ls3statussp.setVisible(true);break;
		case 3:	ls4statussp.setText(status);
				ls4statussp.setVisible(true);break;
		case 4:	ls5statussp.setText(status);
				ls5statussp.setVisible(true);break;
				
			}
		}
	}
	public void resetview() {// View neu starten
		for(int i=0;i<anzahl;i++) {
			switch(i) {
			case 0:s1sum.setText(null);
					ls1status.setVisible(false);
					s1karte1.setImage(null);
					s1karte2.setImage(null);
					s1karte3.setImage(null);
					s1karte4.setImage(null);
					s1karte5.setImage(null);
					s1karte6.setImage(null);
					s1karte7.setImage(null);
					s1karte8.setImage(null);
					s1karte9.setImage(null);
					s1karte10.setImage(null);
					s1sumsp.setText(null);
					ls1statussp.setVisible(false);
					break;
			case 1:	s2sum.setText(null);
					ls2status.setVisible(false);
					s2karte1.setImage(null);
					s2karte2.setImage(null);
					s2karte3.setImage(null);
					s2karte4.setImage(null);
					s2karte5.setImage(null);
					s2karte6.setImage(null);
					s2karte7.setImage(null);
					s2karte8.setImage(null);
					s2karte9.setImage(null);
					s2karte10.setImage(null);
					s2sumsp.setText(null);
					ls2statussp.setVisible(false);
					break;
			case 2: s3sum.setText(null);
					ls3status.setVisible(false);
					s3karte1.setImage(null);
					s3karte2.setImage(null);
					s3karte3.setImage(null);
					s3karte4.setImage(null);
					s3karte5.setImage(null);
					s3karte6.setImage(null);
					s3karte7.setImage(null);
					s3karte8.setImage(null);
					s3karte9.setImage(null);
					s3karte10.setImage(null);
					s3sumsp.setText(null);
					ls3statussp.setVisible(false);
					break;
			case 3:	s4sum.setText(null);
					ls4status.setVisible(false);
					s4karte1.setImage(null);
					s4karte2.setImage(null);
					s4karte3.setImage(null);
					s4karte4.setImage(null);
					s4karte5.setImage(null);
					s4karte6.setImage(null);
					s4karte7.setImage(null);
					s4karte8.setImage(null);
					s4karte9.setImage(null);
					s4karte10.setImage(null);
					s4sumsp.setText(null);
					ls4statussp.setVisible(false);
					break;
			case 4:	s5sum.setText(null);
					ls5status.setVisible(false);
					s5karte1.setImage(null);
					s5karte2.setImage(null);
					s5karte3.setImage(null);
					s5karte4.setImage(null);
					s5karte5.setImage(null);
					s5karte6.setImage(null);
					s5karte7.setImage(null);
					s5karte8.setImage(null);
					s5karte9.setImage(null);
					s5karte10.setImage(null);
					s5sumsp.setText(null);
					ls5statussp.setVisible(false);
					break;
			}
		}
		dsum.setText(null);
		dkarte1.setImage(null);
		dkarte2.setImage(null);
		dkarte3.setImage(null);
		dkarte4.setImage(null);
		dkarte5.setImage(null);
		dkarte6.setImage(null);
		dkarte7.setImage(null);
		dkarte8.setImage(null);
		dkarte9.setImage(null);
		dkarte10.setImage(null);
	}
	public void spielerpanel(boolean v,int i){//v=visible i=spielerid
		switch(i) {
		case 0:ps1.setVisible(v);break;
		case 1:ps2.setVisible(v);break;
		case 2:ps3.setVisible(v);break;
		case 3:ps4.setVisible(v);break;
		case 4:ps5.setVisible(v);break;
		}
	}
	
	//Auswertung


}




























































