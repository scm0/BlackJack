package application;

import javafx.scene.image.Image;

public class Karten {
	private String form;
	private int wert;
	private Image image;
	
public  Karten (String form, int wert,Image image){
	this.form=form;
	this.wert=wert;
	this.image=image;
		
	}

public String getForm() {
	return form;
}

public void setForm(String form) {
	this.form = form;
}

public int getWert() {
	return wert;
}

public void setWert(int wert) {
	this.wert = wert;
}

public Image getImage() {
	return image;
}

public void setImage(Image image) {
	this.image = image;
}

}
