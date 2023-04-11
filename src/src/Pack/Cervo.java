package Pack;

import lejos.nxt.LCD;
import lejos.util.Delay;

public class Cervo {
	
	private CapteurCouleur capteur;
	private Motorisation mot;
	private Memoire mem;
	
	public Cervo(CapteurCouleur ca, Motorisation mo, Memoire me){
		this.mem = me;
		this.mot = mo;
		this.capteur = ca;
	}
	
	public void exo1() throws InterruptedException{
		
		while(capteur.rep()!= 3)
		{
			mot.suivre_ligne();
			capteur.print();
			if(capteur.rep() == 2)
			{
				mot.point_bleu();
				mot.tourner150();
				mem.add(mot.cherhcer_ligne());
			
			}
			else if(capteur.rep() == 1)
			{
				mot.point_vert();
				mot.cherhcer_ligne();
				mem.add(-1);
			}
		}
	}
	
	
	public void exo2() throws InterruptedException{
		//Affichage
		/*
		mem.add(900);
		mem.add(100);
		mem.add(-1);
		mem.add(900);
		mem.add(900);
		mem.add(900);
		*/
		LCD.clear();
		for(int i=0; i<mem.size(); i++ ){
			LCD.drawString(mem.get(i), 2*i, 0);
		}
		
		mem.minimizer();
	
		Thread.sleep(500);
		for(int i=0; i<mem.sizer(); i++ ){
			LCD.drawString(mem.getr(i), 2*i, 3);
		}
		
		Thread.sleep(2000);
		
		
		
		//On fait demi tour
		mot.point_vert();
		mot.cherhcer_ligne();
		
		
		//On reviens à la maison
		for(int i=mem.sizer()-1; i>=0; i-- ){
			
			LCD.drawInt(i, 0, 0);
			mot.suivre_ligne();
			mot.point_bleu();
			
			switch (mem.getE(i)){
            case RIGHT:
                //on tourne à gauche
            	mot.tourner_30();
            	mot.cherhcer_ligne();
            	
            	break;
            case LEFT:
            	mot.tourner150();
            	mot.cherhcer_ligne();
            	
            	break;
            case FOWARD:
            	mot.tourner90();
            	mot.cherhcer_ligne();

            	break;
            case BACKWARD:
            	LCD.drawString("Backward ERROR!", 0, 0);
            	Thread.sleep(2000);
            	break;
            default:
            	LCD.drawString("ERROR!", 0, 0);
            	Thread.sleep(2000);
			}
		}
		
		mot.suivre_ligne();
		LCD.drawString("De retour à la maison!", 0, 0);
		Thread.sleep(200000);
		
		
	}
}
