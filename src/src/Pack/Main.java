package Pack;


import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Delay;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		
		LCD.drawString("Init Start", 0, 0);
		Delay.msDelay(500);
		
		CapteurCouleur capteur = new CapteurCouleur(1);
		Motorisation mot = new Motorisation(capteur);
		Memoire mem = new Memoire();
		Cervo cerv = new Cervo(capteur, mot, mem);
		
		LCD.clear();
		LCD.drawString("Init Complete", 0, 0);
		//Delay.msDelay(500);
		
		
		Button.waitForAnyPress(); 
		
		
		cerv.exo1();
		cerv.exo2();
		
		
		
	}
}
