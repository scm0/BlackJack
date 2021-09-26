package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.image.Image;

public class Deck {
	private ArrayList<Karten> deck =new ArrayList<>();

Deck(){
	
}



public ArrayList<Karten> getDeck() {
	return deck;
}


public void setDeck(ArrayList<Karten> deck) {
	this.deck = deck;
}







public void neuesdeck() {
	
		try {File myFile = new File("rsc/roots.bilder.txt");//öffnen der textdatei mit den Pfaden für die bilder
		
			Scanner myReader = new Scanner(myFile);
			int i=0;
			var z=1;
			String form ;
			
			while (myReader.hasNextLine()) {
				
				switch(z) {
				case 1: form="Herz";break;
				case 2: form="Schaufel";break;
				case 3: form="Ecke";break;
				case 4: form="Kreuz";break;
				case 5: form="leer"; break;
				default: form="default";
				}
				
				String data = myReader.nextLine();
				
				
				Image image = new Image(new FileInputStream(new File(data)));
				
				Karten k =new Karten(form,2+i,image);
				this.deck.add(k);
				
									
				
				i++;
				if(i>12) {
					i=0;
					z++;
				}
			}
			
			myReader.close();
		} catch (FileNotFoundException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			
			
		
		}
	
}
	

}
