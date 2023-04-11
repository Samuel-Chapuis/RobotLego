package Pack;

import lejos.nxt.Motor;
import lejos.util.Delay;

public class Motorisation {
	private static CapteurCouleur cs;
	private int speed = 100;
	
	public Motorisation(CapteurCouleur michel){
		cs = michel;
	}
	
	private void init(){
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
	}
	
	private void out(){
		Motor.A.stop();
		Motor.B.stop();
		Motor.A.setSpeed(0);
		Motor.B.setSpeed(0);
	}
	
	public void tourner_D(){
		Motor.A.setSpeed(0);
		Motor.B.setSpeed(speed);
		while(cs.rep()==6);
	}
	
	public void tourner_30(){
		Motor.A.forward();
		Motor.B.backward();
		
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Delay.msDelay(6*speed);
		
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public void tourner90(){
		Motor.A.backward();
		Motor.B.forward();
		
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Delay.msDelay(18*speed);
		
		Motor.A.stop();
		Motor.B.stop();
	}
	
	public void tourner150(){
		init();
		Motor.A.backward();
		Motor.B.forward();
		
		Delay.msDelay(26*speed);
		
		out();
	}
	
	public int cherhcer_ligne(){
		init();
		Motor.A.forward();
		Motor.B.backward();
		
		int i = 0;
		while(cs.rep()!=7){
			i++;
			// Un tour complet = 2000
			// 180° = 1000
		}
		
		out();
		return i;
	}
	
	public void point_bleu(){
		init();
		Motor.A.forward();
		Motor.B.forward();
		Delay.msDelay(15*speed);
		
		out();
	}
	
	public void point_vert(){
		init();
		Motor.A.forward();
		Motor.B.forward();
		Delay.msDelay((long)7.5*speed);
		
		out();
	}
	
	public void suivre_ligne(){
		Motor.A.setSpeed(10);
		Motor.B.setSpeed(10);
		Motor.A.forward();
		Motor.B.forward();
		while(cs.rep()!= 2 && cs.rep()!= 3 && cs.rep()!= 1){
			cs.print();
			if(cs.rep()==6){
				Motor.A.setSpeed(speed-20+speed/3);
				Motor.B.setSpeed(speed-20);
			}
			if(cs.rep()==7){
				Motor.B.setSpeed(speed-20+speed/3);
				Motor.A.setSpeed(speed-20);
			}
		}
		Motor.A.stop();
		Motor.B.stop();
		Motor.A.setSpeed(0);
		Motor.B.setSpeed(0);
	}

}
