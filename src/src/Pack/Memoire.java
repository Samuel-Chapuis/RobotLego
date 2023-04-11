package Pack;

import java.util.Vector;

import lejos.nxt.LCD;


public class Memoire {

    private Vector<Direction> stockage = new Vector<Direction>();
    private Vector<Direction> retour = new Vector<Direction>();

    public Memoire(){

    }

    //r => right
    //l => left
    //f => foward
    //b => backward


    public void add(int i){
        if(i>0 && i<412){
            stockage.addElement(Direction.RIGHT);
        }else if(i>412 && i<907){
            stockage.addElement(Direction.FOWARD);
        }else if(i>907 && i<1402){
            stockage.addElement(Direction.LEFT);
        }else if(i==-1){
            stockage.addElement(Direction.BACKWARD);
        }
    }

    public int size(){
        return stockage.size();
    }

    public int sizer(){
        return retour.size();
    }

    public String get(int i){
        Direction dir = stockage.elementAt(i);

        switch (dir){
            case RIGHT:
                return "r";
            case LEFT:
                return "l";
            case FOWARD:
                return "f";
            case BACKWARD:
                return "b";
            default:
                return "ERROR";
        }
    }

    public String getr(int i){
        Direction dir = retour.elementAt(i);

        switch (dir){
            case RIGHT:
                return "r";
            case LEFT:
                return "l";
            case FOWARD:
                return "f";
            case BACKWARD:
                return "b";
            default:
                return "ERROR";
        }
    }
    
    public Direction getE(int i){
        return retour.elementAt(i);
    }



    private Vector<Direction> raccourci(Vector<Direction> chemin){
        int n = 0;
        for(int i=0; i<chemin.size() ;i++){
            if(chemin.elementAt(i)==Direction.BACKWARD){
                n++;
            }
        }

        if(n!= 0) {

            for( int j = 1; j < chemin.size() - 1 ; j++) {
                if(chemin.elementAt(j)==Direction.BACKWARD){

                    if(chemin.elementAt(j-1)==Direction.RIGHT && chemin.elementAt(j+1)==Direction.LEFT){
                        //on met b
                        //System.out.println("==> r b l");
                        chemin = remplacer(chemin, j, Direction.BACKWARD);

                    }else if(chemin.elementAt(j-1)==Direction.LEFT && chemin.elementAt(j+1)==Direction.RIGHT){
                        //on met b
                        //System.out.println("==> l b r");
                        chemin = remplacer(chemin, j, Direction.BACKWARD);

                    }else if(chemin.elementAt(j-1)==Direction.LEFT && chemin.elementAt(j+1)==Direction.LEFT){
                        //on met f
                        //System.out.println("==> l b l");
                        chemin = remplacer(chemin, j, Direction.FOWARD);

                    }else if(chemin.elementAt(j-1)==Direction.RIGHT && chemin.elementAt(j+1)==Direction.RIGHT){
                        //on met f
                        //System.out.println("==> r b r");
                        chemin = remplacer(chemin, j, Direction.FOWARD);

                    }else if(chemin.elementAt(j-1)==Direction.RIGHT && chemin.elementAt(j+1)==Direction.FOWARD){
                        //on met l
                        //System.out.println("==> r b f");
                        chemin = remplacer(chemin, j, Direction.LEFT);

                    }else if(chemin.elementAt(j-1)==Direction.FOWARD && chemin.elementAt(j+1)==Direction.RIGHT){
                        //on met l
                        //System.out.println("==> f b r");
                        chemin = remplacer(chemin, j, Direction.LEFT);

                    }else if(chemin.elementAt(j-1)==Direction.LEFT && chemin.elementAt(j+1)==Direction.FOWARD){
                        //on met r
                        //System.out.println("==> l b f");
                        chemin = remplacer(chemin, j, Direction.RIGHT);

                    }else if(chemin.elementAt(j-1)==Direction.FOWARD && chemin.elementAt(j+1)==Direction.LEFT){
                        //on met r
                        //System.out.println("==> f b l");
                        chemin = remplacer(chemin, j, Direction.RIGHT);

                    }else if(chemin.elementAt(j-1)==Direction.FOWARD && chemin.elementAt(j+1)==Direction.FOWARD){
                        //on met b
                        //System.out.println("==> f b f");
                        chemin = remplacer(chemin, j, Direction.BACKWARD);
                    }else {
                        return chemin;
                    }


                }

            }return raccourci( chemin );
        }else{
            return chemin;
        }

    }

    private Vector<Direction> remplacer(Vector<Direction> chemin, int index, Direction ramp){
        chemin.setElementAt(ramp, index);

        chemin.removeElementAt(index-1);
        chemin.removeElementAt(index);



        return chemin;
    }

    public void minimizer(){
        retour = raccourci(stockage);
		/*
		for(int i=0; i<retour.size(); i++ ){
			LCD.drawString(retour.elementAt(i), 2*i, 3);
		}
		*/
    }
}