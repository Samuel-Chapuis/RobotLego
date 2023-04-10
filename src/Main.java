public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Memoire mem = new Memoire();

        mem.add(300); //r
        mem.add(300); //r
        mem.add(300); //r
        mem.add(700); //f
        mem.add(700); //f
        mem.add(1000); //l
        mem.add(1000); //l
        mem.add(300); //r
        mem.add(-1); //b
        mem.add(1000); //l
        mem.add(300); //r
        mem.add(700); //f
        mem.add(-1); //b
        mem.add(300); //r


        for(int i = 0; i < mem.size(); i++){
            System.out.print(mem.get(i));
            System.out.print(" ");
        }

        mem.minimizer();


        System.out.print("\n");
        for(int i = 0; i < mem.sizer(); i++){
            System.out.print(mem.getr(i));
            System.out.print(" ");
        }


    }
}