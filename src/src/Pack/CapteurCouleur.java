package Pack;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;

public class CapteurCouleur {
	private int branchement;
	private ColorSensor cs;
	private int colorValue;
	private String colorName[] = {"RED","GREEN", "BLUE", "YELLOW",
			"MAGENTA", "ORANGE", "WHITE", "BLACK", "PINK", "GRAY",
			"LIGHT_GRAY", "DARK_GRAY", "CYAN"};
	
	
	public CapteurCouleur(int b){
		branchement =  b;
		switch(branchement){
		case 1:
			cs = new ColorSensor(SensorPort.S1);
			break;
		case 2:
			cs = new ColorSensor(SensorPort.S2);
			break;
		case 3:
			cs = new ColorSensor(SensorPort.S3);
			break;
		case 4:
			cs = new ColorSensor(SensorPort.S4);
			break;
		default:
			cs = new ColorSensor(SensorPort.S1);
		}
		
	}
	
	public int rep(){
		colorValue = cs.getColorID();
		return colorValue;
	}
	
	public void print(){
		LCD.clear();
		rep();
		LCD.drawString(colorName[colorValue], 2, 2);
	}
	
}
